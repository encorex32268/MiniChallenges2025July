package com.lihan.minichallenges2025july

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lihan.minichallenges2025july.emojireactionbubble.EmojiReactionBubbleScreen
import com.lihan.minichallenges2025july.emojireactionbubble.EmojiReactionBubbleViewModel
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniChallenges2025JulyTheme {
                val viewModel by viewModels<EmojiReactionBubbleViewModel>()
                val state by viewModel.state.collectAsStateWithLifecycle()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EmojiReactionBubbleScreen(
                        onAction = viewModel::onAction,
                        emojis = state,
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    )
                }
            }
        }
    }
}
