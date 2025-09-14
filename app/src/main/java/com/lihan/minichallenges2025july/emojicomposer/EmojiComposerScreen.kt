package com.lihan.minichallenges2025july.emojicomposer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.minichallenges2025july.emojireactionbubble.EmojiBar
import com.lihan.minichallenges2025july.emojireactionbubble.EmojiType
import com.lihan.minichallenges2025july.fonts.urbanist
import com.lihan.minichallenges2025july.ui.theme.Blue
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme


@Composable
fun EmojiComposerScreen(
    state: EmojiComposerState,
    onAction: (EmojiComposerAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ){
        InteractiveEmojiBar(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            emojiTypes = state.emojiTypes,
            currentEmojiType = state.currentEmoji,
            onAction = onAction
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            value = state.inputText,
            onValueChange = {
                onAction(EmojiComposerAction.OnMessageValueChange(it))
            },
            label = {
                Text(
                    text = "Awesome Message",
                    style = TextStyle(
                        fontFamily = urbanist,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = Blue
                    )
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Blue,
                focusedIndicatorColor = Blue,
                cursorColor = Blue,
                unfocusedLabelColor = Color(0xFF0A0C10),
                focusedLabelColor = Color(0xFF0A0C10),
                focusedContainerColor = Color(0xFF0A0C10),
                unfocusedContainerColor = Color(0xFF0A0C10)
            )
        )

    }
}

@Preview
@Composable
private fun EmojiComposerScreenPreview() {
    MiniChallenges2025JulyTheme {
        EmojiComposerScreen(
            state = EmojiComposerState(),
            onAction = {}
        )
    }
    
}

