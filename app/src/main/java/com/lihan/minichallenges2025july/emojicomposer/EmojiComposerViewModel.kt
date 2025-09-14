package com.lihan.minichallenges2025july.emojicomposer

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.lihan.minichallenges2025july.emojireactionbubble.EmojiType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EmojiComposerViewModel: ViewModel() {

    private val _state = MutableStateFlow(EmojiComposerState())
    val state = _state.asStateFlow()

    private var emojiPositions = mutableMapOf<String, Rect>()

    fun onAction(action: EmojiComposerAction){
        when(action){
            is EmojiComposerAction.OnAddEmojiPosition -> onAddEmojiPosition(action.uniCode,action.rect)
            EmojiComposerAction.OnDragEnd -> onDragEnd()
            is EmojiComposerAction.OnDragStart -> onDragStart(action.startOffset)
            is EmojiComposerAction.OnDragging -> onDragging(action.pointerInputPosition)
            is EmojiComposerAction.OnMessageValueChange -> onMessageValueChange(action.textFieldValue)
            is EmojiComposerAction.OnEmojiTypeClick -> onEmojiTypeClick(action.emojiType)
        }
    }

    private fun onEmojiTypeClick(emojiType: EmojiType) {
        val currentState = state.value
        val newText = currentState.inputText.text + emojiType.uniCode
        val newTextValue = currentState.inputText.copy(
            text = newText,
            selection = TextRange(newText.length)
        )
        _state.update { it.copy(
            inputText = newTextValue,
            currentEmoji = null
        ) }
    }

    private fun onMessageValueChange(textFieldValue: TextFieldValue) {
        _state.update { it.copy(
            inputText = textFieldValue
        ) }
    }

    private fun onAddEmojiPosition(uniCode: String, rect: Rect) {
        emojiPositions.put(
            key = uniCode,
            value = rect
        )
    }

    private fun onDragging(pointerInputPosition: Offset) {
        val newCurrentEmoji = findEmoji(pointerInputPosition)
        _state.update { it.copy(
            currentEmoji = newCurrentEmoji
        ) }
    }

    private fun onDragStart(startOffset: Offset) {
        val newCurrentEmoji = findEmoji(startOffset)
        _state.update { it.copy(
            currentEmoji = newCurrentEmoji
        ) }
    }

    private fun onDragEnd(){
        val currentState = state.value
        val newText = currentState.inputText.text + (currentState.currentEmoji?.uniCode?:"")
        val newTextValue = currentState.inputText.copy(
            text = newText,
            selection = TextRange(newText.length)
        )
        _state.update { it.copy(
            currentEmoji = null,
            inputText = newTextValue
        ) }
    }

    private fun findEmoji(offset: Offset): EmojiType?{
        val currentState = state.value
        val items = currentState.emojiTypes
        emojiPositions.forEach { map ->
            if (map.value.contains(offset)){
                return items.find {
                    it.uniCode == map.key
                }
            }
        }
        return null
    }

}