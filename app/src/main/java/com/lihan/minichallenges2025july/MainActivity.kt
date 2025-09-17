package com.lihan.minichallenges2025july

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges.BottomNavigationWithUnreadBadge
import com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges.BottomNavigationWithUnreadBadgeState
import com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges.BottomNavigationWithUnreadBadgeViewModel
import com.lihan.minichallenges2025july.collapsiblechatthread.Posts
import com.lihan.minichallenges2025july.collapsiblechatthread.data
import com.lihan.minichallenges2025july.emojicomposer.EmojiComposerScreen
import com.lihan.minichallenges2025july.emojicomposer.EmojiComposerViewModel
import com.lihan.minichallenges2025july.messagecard.MessageCardScreen
import com.lihan.minichallenges2025july.messagecard.MessageCardViewModel
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniChallenges2025JulyTheme {

                Scaffold {
                    Posts(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                        ,
                        post = data.first()
                    )

                }
            }
        }
    }
}
