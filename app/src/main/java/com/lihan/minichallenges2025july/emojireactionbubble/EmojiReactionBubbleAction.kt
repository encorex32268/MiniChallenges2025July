package com.lihan.minichallenges2025july.emojireactionbubble

sealed interface EmojiReactionBubbleAction {
    data class OnEmojiBarItemClick(val emojiType: EmojiType): EmojiReactionBubbleAction
}