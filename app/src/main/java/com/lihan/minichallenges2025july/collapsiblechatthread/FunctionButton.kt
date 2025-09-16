package com.lihan.minichallenges2025july.collapsiblechatthread

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.minichallenges2025july.fonts.urbanist
import com.lihan.minichallenges2025july.ui.theme.OnSurface

@Composable
fun FunctionButton(
    icon: ImageVector,
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clickable{
            onClick()
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = OnSurface
        )
        Text(
            text = name,
            style = TextStyle(
                fontFamily = urbanist,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                color = OnSurface
            )
        )

    }

}