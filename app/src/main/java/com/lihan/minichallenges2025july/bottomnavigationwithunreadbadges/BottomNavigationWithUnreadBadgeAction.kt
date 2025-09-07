package com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges

sealed interface BottomNavigationWithUnreadBadgeAction {
    data object OnMarkAsReadClick: BottomNavigationWithUnreadBadgeAction
    data object OnMissACallClick: BottomNavigationWithUnreadBadgeAction
    data object OnSendMessageClick: BottomNavigationWithUnreadBadgeAction
    data object OnBackClick: BottomNavigationWithUnreadBadgeAction
    data class OnBottomItemClick(val bottomNavigationItem: BottomNavigationItem): BottomNavigationWithUnreadBadgeAction
}