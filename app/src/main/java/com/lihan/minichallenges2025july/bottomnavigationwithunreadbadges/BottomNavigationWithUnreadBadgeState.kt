package com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges

data class BottomNavigationWithUnreadBadgeState(
    val bottomItems: List<BottomNavigationItem> = bottomNavigationItems,
    val backstack: List<Route> = listOf<Route>(Route.Settings),
    val selectedRoute: Route = Route.Settings
)


