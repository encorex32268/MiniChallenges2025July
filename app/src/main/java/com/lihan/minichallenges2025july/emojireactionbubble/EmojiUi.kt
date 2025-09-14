package com.lihan.minichallenges2025july.emojireactionbubble

enum class EmojiType(val uniCode: String){
    LIKE("\uD83D\uDC4D"),//👍
    LAUGHING("\uD83D\uDE02"),//😂
    SHOCKED("\uD83D\uDE2E"),//😮
    HEART("❤"),//❤
    SAD("\uD83D\uDE22"),//😢
    GHOST("\uD83D\uDC7B"),//👻
    LOVE_SHINING("\uD83D\uDC96"), //💖
    CRYING("\uD83D\uDE2D"),//😭
    LOVING("\uD83D\uDE0D")//😍
}


data class EmojiUi(
    val emojiType: EmojiType = EmojiType.entries.random(),
    val count: Int = 0
)