package com.lihan.minichallenges2025july.emojicomposer

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.text.input.TextFieldValue
import com.lihan.minichallenges2025july.emojireactionbubble.EmojiType

sealed interface EmojiComposerAction{
    data object OnDragEnd: EmojiComposerAction
    data class OnDragStart(val startOffset: Offset): EmojiComposerAction
    data class OnDragging(val pointerInputPosition: Offset): EmojiComposerAction
    data class OnAddEmojiPosition(val uniCode: String,val rect: Rect): EmojiComposerAction
    data class OnMessageValueChange(val textFieldValue: TextFieldValue): EmojiComposerAction
    data class OnEmojiTypeClick(val emojiType: EmojiType): EmojiComposerAction
}