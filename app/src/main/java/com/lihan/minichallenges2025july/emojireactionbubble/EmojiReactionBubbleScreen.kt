@file:OptIn(ExperimentalLayoutApi::class)

package com.lihan.minichallenges2025july.emojireactionbubble

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.minichallenges2025july.fonts.urbanist
import com.lihan.minichallenges2025july.ui.theme.*
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme


@Composable
fun EmojiReactionBubbleScreen(
    onAction: (EmojiReactionBubbleAction) -> Unit,
    emojis: List<EmojiUi> = emptyList(),
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize().background(brush = BackgroundGradient),
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        EmojiBar(
            onEmojiClick = {
                onAction(EmojiReactionBubbleAction.OnEmojiBarItemClick(it))
            }
        )
        Column(
            modifier = Modifier
                .widthIn(max = 206.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = Surface50)
                .padding(vertical = 12.dp, horizontal = 20.dp)
            ,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ){
            Text(
                text = "Iʼll send the draft tonight.",
                style = TextStyle(
                    fontFamily = urbanist,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    color = OnSurface
                )
            )
            FlowRow(
                modifier = Modifier.animateContentSize(),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ){
                emojis.forEach { emojiUi -> 
                    Emoji(
                        emojiType = emojiUi.emojiType,
                        count = emojiUi.count,
                        backgroundColor = Blue12,
                        onEmojiClick = {}
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun EmojiReactionBubbleScreenPreview() {
    MiniChallenges2025JulyTheme {
        EmojiReactionBubbleScreen(
            onAction = {},
            emojis = listOf(
                EmojiUi(
                    emojiType = EmojiType.SAD,
                    count = 1
                ),
                EmojiUi(
                    emojiType = EmojiType.LIKE,
                    count = 0
                ),
                EmojiUi(
                    emojiType = EmojiType.LAUGHING,
                    count = 5
                )
            )
        )
    }
}