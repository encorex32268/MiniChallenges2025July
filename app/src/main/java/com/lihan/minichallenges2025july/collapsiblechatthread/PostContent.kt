package com.lihan.minichallenges2025july.collapsiblechatthread

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.minichallenges2025july.fonts.urbanist
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme
import com.lihan.minichallenges2025july.ui.theme.OnSurface
import com.lihan.minichallenges2025july.ui.theme.OnSurfaceVar
import com.lihan.minichallenges2025july.ui.theme.SurfaceAlt30

@Composable
fun PostContent(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth().height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    ){
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ){
            Canvas(modifier = Modifier.fillMaxSize()) {
                val path = Path().apply {
                    moveTo(x = size.width/2f, y =  0f)
                    lineTo(x = size.width/2f, y =  size.height)
                }
                drawPath(
                    path = path,
                    color = SurfaceAlt30,
                    style = Stroke(
                        width = 1.dp.toPx()
                    )
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(9f)
                .padding(bottom = 10.dp)
        ){
            if (title.isNotEmpty()){
                Text(
                    text = title,
                    style = TextStyle(
                        fontFamily = urbanist,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        color = OnSurface
                    )
                )
            }
            if (content.isNotEmpty()){
                Text(
                    text = content,
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
}

@Preview
@Composable
private fun PostContentPreview() {
    MiniChallenges2025JulyTheme {
        PostContent(
            title = "This is Title",
            content = "This is Content"
        )
    }
    
}