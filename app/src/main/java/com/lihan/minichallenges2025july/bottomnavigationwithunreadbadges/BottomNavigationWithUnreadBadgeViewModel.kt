package com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BottomNavigationWithUnreadBadgeViewModel: ViewModel() {
    private val _state = MutableStateFlow(BottomNavigationWithUnreadBadgeState())
    val state = _state.asStateFlow()


    fun onAction(action: BottomNavigationWithUnreadBadgeAction){
        when(action){
            BottomNavigationWithUnreadBadgeAction.OnMarkAsReadClick -> onMarkAsReadClick()
            BottomNavigationWithUnreadBadgeAction.OnMissACallClick -> onMissACallClick()
            BottomNavigationWithUnreadBadgeAction.OnSendMessageClick -> onSendMessageClick()
            BottomNavigationWithUnreadBadgeAction.OnBackClick -> onBackClick()
            is BottomNavigationWithUnreadBadgeAction.OnBottomItemClick -> onBottomItemClick(action.bottomNavigationItem)
        }
    }


    private fun onMarkAsReadClick() {
        _state.update { it.copy(
            bottomItems = it.bottomItems.map { bottomItem ->
                if (bottomItem.route == Route.Chats || bottomItem.route == Route.Calls){
                    bottomItem.copy(isRead = true)
                }else{
                    bottomItem
                }
            }
        ) }
    }
    private fun onMissACallClick() {
        _state.update { it.copy(
            bottomItems = it.bottomItems.mapWhenItemNewNotification(route = Route.Calls)
        ) }
    }
    private fun onSendMessageClick() {
        _state.update { it.copy(
            bottomItems = it.bottomItems.mapWhenItemNewNotification(route = Route.Chats)
        ) }
    }

    private fun onBackClick() {
        if (state.value.backstack.size > 1){
            _state.update { it.copy(
                backstack = it.backstack.dropLast(1)
            ) }
        }
    }

    private fun onBottomItemClick(bottomNavigationItem: BottomNavigationItem) {
        val currentState = state.value
        if(currentState.backstack.isNotEmpty()){
            _state.update { it.copy(
                backstack = listOf(bottomNavigationItem.route),
                selectedRoute = bottomNavigationItem.route,
                bottomItems = it.bottomItems.mapWhenBottomItemClick(route = bottomNavigationItem.route)
            ) }
        }else{
            //Give default route when backstack is empty.
            _state.update { it.copy(
                backstack = listOf(Route.Settings)
            ) }
        }
    }

}

private fun List<BottomNavigationItem>.mapWhenItemNewNotification(route: Route): List<BottomNavigationItem>{
    return this.map {
        if (it.route == route){
            it.copy(isRead = false)
        }else{
            it
        }
    }
}

private fun List<BottomNavigationItem>.mapWhenBottomItemClick(route: Route): List<BottomNavigationItem>{
    return this.map {
        if (it.route == route){
            it.copy(isRead = true)
        }else{
            it
        }
    }
}