package com.lihan.minichallenges2025july.messagecard

sealed interface MessageCardAction{
    data object OnSentClick: MessageCardAction
    data object OnDeliveredClick: MessageCardAction
    data object OnReadClick: MessageCardAction
}