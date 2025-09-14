package com.lihan.minichallenges2025july.emojicomposer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.minichallenges2025july.emojireactionbubble.EmojiType
import com.lihan.minichallenges2025july.fonts.urbanist
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme
import com.lihan.minichallenges2025july.ui.theme.OnSurface
import com.lihan.minichallenges2025july.ui.theme.SurfaceAlt15

@Composable
fun InteractiveEmoji(
    emojiType: EmojiType,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .wrapContentSize()
            .drawBehind{
                if (isSelected){
                    drawCircle(
                        color = SurfaceAlt15,
                        radius = 24.dp.toPx()
                    )
                }
            },
        text = emojiType.uniCode,
        style = TextStyle(
            fontFamily = urbanist,
            fontSize =  if(isSelected) 35.sp else 18.sp,
            fontWeight = FontWeight.Normal,
            color = OnSurface,
            textAlign = TextAlign.Center
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun InteractiveEmojiPreview() {
    MiniChallenges2025JulyTheme {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ){
            InteractiveEmoji(
                emojiType = buildEmojiTypes().first(),
                isSelected = true
            )
        }
    }
}