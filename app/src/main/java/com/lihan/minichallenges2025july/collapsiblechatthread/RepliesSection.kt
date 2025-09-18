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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme
import com.lihan.minichallenges2025july.ui.theme.SurfaceAlt30
import kotlin.math.roundToInt

@Composable
fun RepliesSection(
    replies: List<Comment>
) {

    val commentPositions = remember(replies) {
        mutableStateListOf<Offset>()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .onGloballyPositioned {
                commentPositions.clear()
            },
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                if (commentPositions.isNotEmpty()) {
                    val mainLinePath = Path().apply {
                        moveTo(x = size.width / 2, y = 0f)
                        lineTo(x = size.width / 2, y = commentPositions.last().y.roundToInt().toFloat()+ 36.dp.toPx())
                    }
                    drawPath(path = mainLinePath, color = SurfaceAlt30, style = Stroke(width = 1.dp.toPx()))
                    commentPositions.forEach { offset ->
                        val horizontalLinePath = Path().apply {
                            moveTo(x = size.width / 2, y = offset.y + 36.dp.toPx())
                            lineTo(x = size.width, y = offset.y + 36.dp.toPx())
                        }
                        drawPath(path = horizontalLinePath, color = SurfaceAlt30, style = Stroke(width = 1.dp.toPx()))
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .weight(9f),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            replies.forEachIndexed { index, comment ->
                Posts(
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        commentPositions.add(coordinates.positionInParent())
                    },
                    post = comment.toPost()
                )
            }
        }
    }
}

@Preview
@Composable
private fun RepliesSectionPreview() {
    MiniChallenges2025JulyTheme {
        RepliesSection(
            replies = data.first().replies
        )
    }
    
}
