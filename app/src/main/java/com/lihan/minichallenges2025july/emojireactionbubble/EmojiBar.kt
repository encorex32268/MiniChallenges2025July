package com.lihan.minichallenges2025july.emojireactionbubble

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme

@Composable
fun EmojiBar(
    onEmojiClick: (EmojiType) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(22.dp))
            .background(color = Surface30)
            .border(width = 1.dp, color = Surface50, shape = RoundedCornerShape(22.dp))
        ,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        EmojiType.entries.forEach { emojiType ->
            Emoji(
                modifier = Modifier.padding(4.dp),
                emojiType = emojiType,
                onEmojiClick = onEmojiClick,
                clickEnable = true
            )
        }
    }


}

@Preview(showBackground = true)
@PreviewLightDark
@Composable
private fun EmojiBarPreview() {
    MiniChallenges2025JulyTheme {
        EmojiBar(
            onEmojiClick = {}
        )
    }

}