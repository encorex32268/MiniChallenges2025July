package com.lihan.minichallenges2025july.messagecard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.minichallenges2025july.R
import com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges.CustomOutlineButton
import com.lihan.minichallenges2025july.fonts.urbanist
import com.lihan.minichallenges2025july.ui.theme.BackgroundGradient
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme
import com.lihan.minichallenges2025july.ui.theme.OnSurface
import com.lihan.minichallenges2025july.ui.theme.OnSurfaceAlt
import com.lihan.minichallenges2025july.ui.theme.OnSurfaceVar
import com.lihan.minichallenges2025july.ui.theme.Primary
import com.lihan.minichallenges2025july.ui.theme.Surface50
import com.lihan.minichallenges2025july.ui.theme.SurfaceAlt

@Composable
fun MessageCardScreen(
    state: MessageCardState,
    onAction: (MessageCardAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(brush = BackgroundGradient),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ){
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(color = Primary)
                        .align(Alignment.Bottom),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "D",
                        style = TextStyle(
                            fontFamily = urbanist,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = OnSurfaceAlt,
                            textAlign = TextAlign.Center
                        )
                    )
                }
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(22.dp))
                        .background(Surface50)
                        .weight(1f)
                        .padding(vertical = 12.dp, horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            modifier = Modifier.weight(1f),
                            text = "DreamSyntaxHiker",
                            style = TextStyle(
                                fontFamily = urbanist,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                color = OnSurface
                            )
                        )
                        Text(
                            text = "1 day ago",
                            style = TextStyle(
                                fontFamily = urbanist,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = SurfaceAlt.copy(alpha = 0.3f)
                            )
                        )
                    }
                    Text(
                        text = "Iʼll send the draft tonight.I spent 9 months building what I thought would be a simple app to help people learn new languages through short conversations. I poured my evenings and weekends into it, but the launch was... underwhelming. ",
                        style = TextStyle(
                            fontFamily = urbanist,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            color = OnSurface
                        )
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = ImageVector.vectorResource(state.messageStatusIcon),
                            contentDescription = null,
                            tint = state.messageStatusColor
                        )
                        Text(
                            text = state.messageStatusText,
                            style = TextStyle(
                                fontFamily = urbanist,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 11.sp,
                                color = state.messageStatusColor
                            )
                        )
                    }

                }

            }

        }
        Box {
            Column{
                CustomOutlineButton(
                    onClick = {
                        onAction(MessageCardAction.OnSentClick)
                    },
                    text = "Mark as Sent",
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.read),
                            contentDescription = "SentRead",
                            tint = if (state.status == MessageStatus.SENT) OnSurfaceVar else Primary,
                        )
                    },
                    isSelected = state.status == MessageStatus.SENT
                )
                CustomOutlineButton(
                    onClick = {
                        onAction(MessageCardAction.OnDeliveredClick)
                    },
                    text = "Mark as Delivered",
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.read),
                            contentDescription = "DeliveredRead",
                            tint = if (state.status == MessageStatus.DELIVERED) OnSurfaceVar else Primary,

                            )
                    },
                    isSelected = state.status == MessageStatus.DELIVERED
                )
                CustomOutlineButton(
                    onClick = {
                        onAction(MessageCardAction.OnReadClick)
                    },
                    text = "Mark as Read",
                    leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.read),
                            contentDescription = "ReadRead",
                            tint = if (state.status == MessageStatus.READ) OnSurfaceVar else Primary,
                        )
                    },
                    isSelected = state.status == MessageStatus.READ
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MessageCardScreenPreview() {
    MiniChallenges2025JulyTheme {
        MessageCardScreen(
            state = MessageCardState(),
            onAction = {}
        )
    }

}