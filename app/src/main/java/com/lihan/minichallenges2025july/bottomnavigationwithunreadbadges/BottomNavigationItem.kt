package com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges

import androidx.annotation.DrawableRes
import com.lihan.minichallenges2025july.R

data class BottomNavigationItem(
    val route: Route,
    @DrawableRes val icon: Int,
    val isRead: Boolean = true
)

val bottomNavigationItems = listOf<BottomNavigationItem>(
    BottomNavigationItem(
        route = Route.Chats,
        icon = R.drawable.message
    ),
    BottomNavigationItem(
        route = Route.Calls,
        icon = R.drawable.phone
    ),
    BottomNavigationItem(
        route = Route.Settings,
        icon = R.drawable.settings
    )
)
