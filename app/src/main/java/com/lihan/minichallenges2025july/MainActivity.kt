package com.lihan.minichallenges2025july

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.lihan.minichallenges2025july.collapsiblechatthread.CollapsibleChatThread
import com.lihan.minichallenges2025july.collapsiblechatthread.data
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniChallenges2025JulyTheme {
                Scaffold {
                    CollapsibleChatThread(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        data = data
                    )
                }
            }
        }
    }
}
