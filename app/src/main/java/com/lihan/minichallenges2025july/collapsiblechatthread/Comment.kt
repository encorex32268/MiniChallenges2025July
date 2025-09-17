package com.lihan.minichallenges2025july.collapsiblechatthread

import androidx.compose.ui.graphics.Color

data class Comment(
    val username: String,
    val time: String,
    val iconBackground: Color,
    val badge: String = "",
    val badgeColor: Color = Color.Unspecified,
    val badgeTextColor: Color = Color.Unspecified,
    val content: String,
    val replies: List<Comment> = emptyList()
)


fun Comment.toPost(): Post {
    return Post(
        username = username,
        time = time,
        channel = badge,
        channelColor = badgeColor,
        title = "",
        content = content,
        replies = replies,
        iconBackground = iconBackground,
        channelTextColor = badgeTextColor
    )
}