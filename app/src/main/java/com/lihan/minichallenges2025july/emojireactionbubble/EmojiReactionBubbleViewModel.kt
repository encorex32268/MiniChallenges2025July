package com.lihan.minichallenges2025july.emojireactionbubble

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EmojiReactionBubbleViewModel: ViewModel() {

    private val _state = MutableStateFlow(listOf<EmojiUi>())
    val state = _state.asStateFlow()

    fun onAction(action: EmojiReactionBubbleAction){
        when(action){
            is EmojiReactionBubbleAction.OnEmojiBarItemClick -> onEmojiBarItemClick(action.emojiType)
        }
    }

    private fun onEmojiBarItemClick(emojiType: EmojiType) {
        println("onEmojiBarItemClick $emojiType")
        val emojiUis = state.value.map { it.emojiType.uniCode }
        val isExists = emojiType.uniCode in emojiUis
        if (isExists){
            _state.update { state ->
                state.map { emojiUi ->
                    if (emojiUi.emojiType.uniCode == emojiType.uniCode){
                        emojiUi.copy(count = emojiUi.count + 1)
                    }else{
                        emojiUi
                    }
                }
            }
        }else{
            _state.update { state ->
                state + EmojiUi(emojiType = emojiType , count = 0)
            }
        }
        println("State ${_state.value}")
    }

}