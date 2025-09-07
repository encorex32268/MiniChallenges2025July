package com.lihan.minichallenges2025july.emojireactionbubble

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.minichallenges2025july.fonts.urbanist
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme

@Composable
fun Emoji(
    clickEnable: Boolean = false,
    emojiType: EmojiType,
    onEmojiClick: (EmojiType) -> Unit,
    count: Int = 0,
    backgroundColor: Color = Color.Unspecified,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable(
                enabled =  clickEnable,
                onClick = {
                    onEmojiClick(emojiType)
                }
            )
            .padding(4.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Text(
            text = emojiType.uniCode,
            style = TextStyle(
                fontFamily = urbanist,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = OnSurface
            )
        )
        if (count > 0){
            Text(
                modifier = Modifier.padding(start = 6.dp),
                text = "$count",
                style = TextStyle(
                    fontFamily = urbanist,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = OnSurface
                )
            )
        }


    }


}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun EmojiPreview() {
    MiniChallenges2025JulyTheme {
        Emoji(
            emojiType = EmojiType.entries.random(),
            count = 1,
            onEmojiClick = {}
        )
    }
}