package com.lihan.minichallenges2025july.collapsiblechatthread

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
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
import com.lihan.minichallenges2025july.ui.theme.OnSurface
import com.lihan.minichallenges2025july.ui.theme.OnSurfaceAlt
import com.lihan.minichallenges2025july.ui.theme.OnSurfaceVar
import com.lihan.minichallenges2025july.ui.theme.Primary
import com.lihan.minichallenges2025july.ui.theme.Surface50

@Composable
fun UserInfoHeader(
    name: String,
    time: String,
    iconBackgroundColor: Color = Primary,
    badge: String = "",
    badgeColor: Color = Color.Unspecified,
    badgeTextColor: Color = Color.Unspecified,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = if (badge.isNotEmpty()) Alignment.Top else Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = iconBackgroundColor)
                .size(36.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = name.first().toString(),
                style = TextStyle(
                    fontFamily = urbanist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = OnSurfaceAlt
                )
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = name,
                    style = TextStyle(
                        fontFamily = urbanist,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = OnSurface
                    )
                )
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = OnSurfaceVar)
                        .size(4.dp)
                )
                Text(
                    text = time,
                    style = TextStyle(
                        fontFamily = urbanist,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = OnSurfaceVar
                    )
                )
            }
            if (badge.isNotEmpty()){
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = badgeColor)
                        .padding(vertical = 3.dp, horizontal = 6.dp)
                    ,
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = badge,
                        style = TextStyle(
                            fontFamily = urbanist,
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                            color = badgeTextColor
                        )
                    )
                }
            }

        }


    }

}

@Preview
@Composable
private fun UserInfoHeaderPreview() {
    MiniChallenges2025JulyTheme {
        val user = data.first()
        UserInfoHeader(
            name = user.username,
            time = user.time,
            badge = user.channel,
            badgeColor = Surface50
        )
    }

}