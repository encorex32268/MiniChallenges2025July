package com.lihan.minichallenges2025july.emojicomposer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.lihan.minichallenges2025july.emojireactionbubble.EmojiType
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme
import com.lihan.minichallenges2025july.ui.theme.Surface30
import com.lihan.minichallenges2025july.ui.theme.Surface50

@Composable
fun InteractiveEmojiBar(
    currentEmojiType: EmojiType?,
    onAction: (EmojiComposerAction) -> Unit,
    emojiTypes: List<EmojiType> = emptyList(),
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(56.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(color = Surface30)
            .border(width = 1.dp, color = Surface50, shape = RoundedCornerShape(100.dp))
            .pointerInput(Unit) {
                detectDragGesturesAfterLongPress(
                    onDragStart = { offset ->
                        onAction(EmojiComposerAction.OnDragStart(startOffset = offset))
                    },
                    onDragEnd = {
                        onAction(EmojiComposerAction.OnDragEnd)
                    },
                    onDrag = { pointerInputChange, _ ->
                        onAction(EmojiComposerAction.OnDragging(pointerInputPosition =  pointerInputChange.position))
                    }
                )
            }
            .padding(4.dp)
        ,
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ){
        emojiTypes.forEach { emojiType ->
            InteractiveEmoji(
                modifier = Modifier
                    .padding(4.dp)
                    .widthIn(min = 40.dp)
                    .heightIn(min = 32.dp)
                    .onGloballyPositioned { coordinates ->
                        val rect = Rect(
                            offset = coordinates.positionInParent(),
                            size = coordinates.size.toSize()
                        )
                        onAction(
                            EmojiComposerAction.OnAddEmojiPosition(
                                uniCode = emojiType.uniCode,
                                rect = rect
                            )
                        )
                    }
                    .pointerInput(Unit){
                        detectTapGestures(
                            onTap = {
                                onAction(
                                    EmojiComposerAction.OnEmojiTypeClick(
                                        emojiType = emojiType
                                    )
                                )
                            }
                        )
                    }
                ,
                emojiType = emojiType,
                isSelected = currentEmojiType?.uniCode == emojiType.uniCode

            )
        }
    }
}

@Preview
@Composable
private fun InteractiveEmojiBarPreview() {
    MiniChallenges2025JulyTheme {
        val emojiTypes by remember {
            mutableStateOf(
                buildEmojiTypes()
            )
        }
        InteractiveEmojiBar(
            currentEmojiType = emojiTypes.first(),
            onAction = {},
            emojiTypes = emojiTypes
        )
    }

}