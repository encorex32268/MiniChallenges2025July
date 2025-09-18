package com.lihan.minichallenges2025july.collapsiblechatthread

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme

@Composable
fun Posts(
    modifier: Modifier = Modifier,
    post: Post,
) {
    var isExpend by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = if (post.title.isNotEmpty())  20.dp else  10.dp)
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

        AnimatedVisibility(isExpend) {
            RepliesSection(
                replies = post.replies
            )
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
