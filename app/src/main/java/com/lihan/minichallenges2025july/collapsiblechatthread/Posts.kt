package com.lihan.minichallenges2025july.collapsiblechatthread

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme
import com.lihan.minichallenges2025july.ui.theme.SurfaceAlt30
import kotlin.math.roundToInt

@Composable
fun Posts(
    modifier: Modifier = Modifier,
    post: Post,
) {
    var isExpend by remember {
        mutableStateOf(false)
    }

    val commentOffsets = remember(post){
        mutableListOf<Offset>()
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .verticalScroll(state = rememberScrollState()),
    ){
        UserInfoHeader(
            name = post.username,
            time = post.time,
            badge = post.channel,
            badgeColor = post.channelColor,
            badgeTextColor = post.channelTextColor,
            iconBackgroundColor = post.iconBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        PostContent(
            title = post.title,
            content = post.content
        )
        FunctionSection(
            isExpend = isExpend,
            repliesSize = post.replies.size,
            onExpend = {
                isExpend = true
            },
            onCollapse = {
                isExpend = false
            }
        )
        if (isExpend){
            Row(
                modifier = modifier.fillMaxWidth().height(IntrinsicSize.Min)
            ){
                Box(
                    modifier = Modifier.weight(1f)
                ){
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        commentOffsets.forEach{ offset ->
                            val tempPath = Path().apply {
                                moveTo(x = size.width/2 , y = (offset.y + 36.dp.toPx()).roundToInt().toFloat())
                                lineTo(x = size.width , y = (offset.y + 36.dp.toPx()).roundToInt().toFloat())
                            }
                            drawPath(path = tempPath , color = SurfaceAlt30 , style = Stroke(width = 1.dp.toPx().roundToInt().toFloat()))
                        }
                        val path = Path().apply {
                            moveTo(x = size.width / 2 , y =  0f)
                            lineTo(x = size.width / 2 , y =  (commentOffsets.last().y+ 36.dp.toPx()).roundToInt().toFloat())
                        }
                        drawPath(path = path , color = SurfaceAlt30 , style = Stroke(width = 1.dp.toPx().roundToInt().toFloat()))

                    }
                }
                Column(
                    modifier = Modifier.padding(top = 20.dp).weight(9f),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ){
                    post.replies.forEachIndexed { index , comment ->
                        Posts(
                            modifier = Modifier.onGloballyPositioned{
                                commentOffsets.add(index,it.positionInParent())
                            },
                            post = comment.toPost()
                        )
                    }
                }

            }

        }

    }
}


@Preview
@Composable
private fun PostSectionPreview() {
    MiniChallenges2025JulyTheme {
        Posts(
            post = data.first()
        )
    }

}
