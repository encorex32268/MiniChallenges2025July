package com.lihan.minichallenges2025july.messagecard

import androidx.annotation.DrawableRes
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.lihan.minichallenges2025july.R
import com.lihan.minichallenges2025july.ui.theme.Blue
import com.lihan.minichallenges2025july.ui.theme.OnSurfaceVar

data class MessageCardState(
    val status: MessageStatus = MessageStatus.SENT
){
    val messageStatusText: String
        get() {
            return when(status){
                MessageStatus.SENT -> "Sent"
                MessageStatus.DELIVERED -> "Delivered"
                MessageStatus.READ -> "Read"
            }
        }

    val messageStatusColor: Color
        get() {
            return when(status){
                MessageStatus.SENT,
                MessageStatus.DELIVERED -> OnSurfaceVar
                MessageStatus.READ -> Blue
            }
        }

    val messageStatusIcon: Int
        get() {
            return when(status){
                MessageStatus.SENT -> R.drawable.unread
                MessageStatus.DELIVERED,
                MessageStatus.READ -> R.drawable.read
            }
        }
}


enum class MessageStatus{
    SENT,DELIVERED,READ
}