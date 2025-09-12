package com.lihan.minichallenges2025july.messagecard

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MessageCardViewModel: ViewModel() {

    private val _state = MutableStateFlow(MessageCardState())
    val state = _state.asStateFlow()

    fun onAction(action: MessageCardAction){
        when(action){
            MessageCardAction.OnDeliveredClick ->onDeliveredClick()
            MessageCardAction.OnReadClick -> onReadClick()
            MessageCardAction.OnSentClick -> onSentClick()
        }
    }

    private fun onSentClick() {
        if (state.value.status == MessageStatus.SENT) return
        _state.update { it.copy(
            status = MessageStatus.SENT
        ) }
    }

    private fun onReadClick() {
        if (state.value.status == MessageStatus.READ) return
        _state.update { it.copy(
            status = MessageStatus.READ
        ) }
    }

    private fun onDeliveredClick() {
        if (state.value.status == MessageStatus.DELIVERED) return
        _state.update { it.copy(
            status = MessageStatus.DELIVERED
        ) }
    }
}