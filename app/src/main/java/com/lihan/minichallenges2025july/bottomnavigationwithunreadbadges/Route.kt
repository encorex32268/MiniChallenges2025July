package com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges


sealed class Route(val path: String){
    data object Chats: Route("Chats")
    data object Calls: Route("Calls")
    data object Settings: Route("Settings")
}
