package com.lihan.minichallenges2025july.collapsiblechatthread

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lihan.minichallenges2025july.R
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme
import com.lihan.minichallenges2025july.ui.theme.SurfaceAlt30
import kotlin.math.roundToInt

@Composable
fun FunctionSection(
    onCollapse: () -> Unit,
    onExpend: () -> Unit,
    isExpend: Boolean = true,
    repliesSize: Int = 0,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ){
            if (isExpend){
                FunctionButton(
                    modifier = Modifier.padding(start = 8.dp),
                    icon = ImageVector.vectorResource(R.drawable.minus_circle),
                    name = "",
                    onClick = onCollapse
                )
            }else{
                Canvas(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val path  = Path().apply {
                        moveTo(x = size.width /2 , y = 0f)
                        lineTo(x = size.width /2 , y = size.height/2)
                        lineTo(x = size.width, y = size.height/2)
                    }
                    drawPath(
                        path = path,
                        color = SurfaceAlt30 ,
                        style = Stroke(
                            width = 1.dp.toPx().roundToInt().toFloat(),
                            join = StrokeJoin.Round
                        ))
                }

            }
        }
        Row(
            modifier = Modifier.weight(9f),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            if (repliesSize > 0 && !isExpend){
                FunctionButton(
                    icon = ImageVector.vectorResource(R.drawable.plus_circle),
                    name = "Show $repliesSize replies",
                    onClick = onExpend
                )
            }
            FunctionButton(
                icon = ImageVector.vectorResource(R.drawable.reply),
                name = "Reply",
                onClick = {}
            )

        }
    }

}

@Preview
@Composable
private fun FunctionSectionPreview() {
    MiniChallenges2025JulyTheme {
        FunctionSection(
            repliesSize = 3,
            onExpend = {},
            onCollapse = {}
        )
    }

}

