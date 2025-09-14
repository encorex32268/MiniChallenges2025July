package com.lihan.minichallenges2025july.emojicomposer

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.ui.text.input.TextFieldValue
import com.lihan.minichallenges2025july.emojireactionbubble.EmojiType
import com.lihan.minichallenges2025july.emojireactionbubble.EmojiUi

data class EmojiComposerState(
    val inputText: TextFieldValue = TextFieldValue(""),
    val emojiTypes: List<EmojiType> = buildEmojiTypes(),
    val currentEmoji: EmojiType? = null
)

fun buildEmojiTypes() = listOf(
    EmojiType.LAUGHING,
    EmojiType.LOVING,
    EmojiType.GHOST,
    EmojiType.LOVE_SHINING,
    EmojiType.CRYING,
)