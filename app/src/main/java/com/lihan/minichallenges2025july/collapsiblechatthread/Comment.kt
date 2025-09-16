package com.lihan.minichallenges2025july.collapsiblechatthread

data class Comment(
    val username: String,
    val time: String,
    val badge: String = "",
    val content: String,
    val replies: List<Comment> = emptyList()
)
