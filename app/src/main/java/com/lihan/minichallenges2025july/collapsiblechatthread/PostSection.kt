package com.lihan.minichallenges2025july.collapsiblechatthread

import android.graphics.PorterDuff
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageBitmapConfig
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.draw
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.minichallenges2025july.R
import com.lihan.minichallenges2025july.fonts.urbanist
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme
import com.lihan.minichallenges2025july.ui.theme.OnSurface
import com.lihan.minichallenges2025july.ui.theme.OnSurfaceAlt
import com.lihan.minichallenges2025july.ui.theme.OnSurfaceVar
import com.lihan.minichallenges2025july.ui.theme.Primary
import com.lihan.minichallenges2025july.ui.theme.Surface50
import com.lihan.minichallenges2025july.ui.theme.SurfaceAlt30
import kotlin.math.roundToInt

@Composable
fun PostSection(
    modifier: Modifier = Modifier,
    post: Post,
) {
    val imageVector = ImageVector.vectorResource(id = R.drawable.minus_circle)
    val vectorPainter = rememberVectorPainter(image = imageVector)

    Column {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min)
        ){
            Column(
                modifier = Modifier.weight(1f)
            ){
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = Primary)
                        .size(36.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "${post.username.first()}",
                        style = TextStyle(
                            fontFamily = urbanist,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp,
                            color = OnSurfaceAlt
                        )
                    )
                }
                Canvas(
                    modifier = Modifier.fillMaxSize().weight(1f)
                ) {

                    val path = Path().apply {
                        // 從起點開始
                        moveTo(x = size.width/2, y = 10.dp.toPx())
                        // 畫一條直線到轉角點
                        lineTo(x = size.width/2, y = size.height - 10.dp.toPx())
                        // 畫另一條直線到終點
                        lineTo(x = size.width/2, y = size.height)
                    }
                    drawPath(
                        path = path,
                        color = SurfaceAlt30,
                        style = Stroke(
                            width = 1.dp.toPx(),
                            join = StrokeJoin.Round // 這是關鍵！讓線段的轉角處是圓角
                        )
                    )
                }
            }
            Spacer(Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(9f),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ){
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ){
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = post.username,
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
                            text = post.time,
                            style = TextStyle(
                                fontFamily = urbanist,
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp,
                                color = OnSurfaceVar
                            )
                        )
                    }
                    if (post.channel.isNotEmpty()){
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(color = Surface50)
                                .padding(vertical = 3.dp, horizontal = 6.dp)
                            ,
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = post.channel,
                                style = TextStyle(
                                    fontFamily = urbanist,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 10.sp,
                                    color = OnSurfaceVar
                                )
                            )
                        }
                    }

                }
                Column(
                    modifier = Modifier.padding(bottom = 10.dp)
                ){
                    Text(
                        text = post.title,
                        style = TextStyle(
                            fontFamily = urbanist,
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,
                            color = OnSurface
                        )
                    )
                    Text(
                        text = post.content,
                        style = TextStyle(
                            fontFamily = urbanist,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            color = OnSurfaceVar
                        )
                    )

                }

            }
        }
        Row(
            modifier = Modifier.height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Canvas(
                modifier = Modifier.fillMaxSize().weight(1f)
            ) {
                val path = Path().apply {
                    // 從起點開始
                    moveTo(x = size.width/2, y = 0f)
                    // 畫一條直線到轉角點
                    lineTo(x = size.width/2, y = size.height - 10.dp.toPx())
                    // 畫另一條直線到終點
                    lineTo(x = size.width , y = size.height - 10.dp.toPx())
                }
                drawPath(
                    path = path,
                    color = SurfaceAlt30,
                    style = Stroke(
                        width = 1.dp.toPx(),
                        join = StrokeJoin.Round // 這是關鍵！讓線段的轉角處是圓角
                    )
                )
            }
            Row(
                modifier = Modifier.weight(9f)
            ){
                FunctionButton(
                    icon = ImageVector.vectorResource(R.drawable.plus_circle),
                    name = "Show ${post.replies.size} replies",
                    onClick = {

                    }
                )
                FunctionButton(
                    icon = ImageVector.vectorResource(R.drawable.reply),
                    name = "Reply",
                    onClick = {

                    }
                )

            }
        }

    }
}


@Preview
@Composable
private fun PostSectionPreview() {
    MiniChallenges2025JulyTheme {
        PostSection(
            post = data.first()
        )
    }

}
