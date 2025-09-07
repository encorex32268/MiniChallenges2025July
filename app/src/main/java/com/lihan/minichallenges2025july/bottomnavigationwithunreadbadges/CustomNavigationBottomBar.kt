package com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.lihan.minichallenges2025july.ui.theme.Error
import com.lihan.minichallenges2025july.ui.theme.Surface30
import com.lihan.minichallenges2025july.ui.theme.Surface50

@Composable
fun CustomNavigationBottomBar(
    currentRoute: Any?,
    onBottomItemClick: (BottomNavigationItem) -> Unit,
    bottomItems: List<BottomNavigationItem>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth().navigationBarsPadding(),
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .dropShadow(
                    shape = RoundedCornerShape(18.dp),
                    shadow = androidx.compose.ui.graphics.shadow.Shadow(
                        radius = 40.dp,
                        color = Color(0xFF06060A).copy(alpha = 0.5f),
                        offset = DpOffset(x = 0.dp, y = 4.dp)
                    )
                )
                .background(color = Surface30)
                .border(1.dp, color = Surface50)
                .padding(6.dp)

        ){
            bottomItems.forEach { item ->
                val isSelected = item.route == currentRoute
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isSelected) Color.White else Color.Unspecified)
                        .clickable{
                            onBottomItemClick(item)
                        }
                    ,
                    contentAlignment = Alignment.Center
                ){
                    if (!item.isRead){
                        Badge(
                            modifier = Modifier.align(Alignment.TopEnd).offset(x = (-12).dp, y = 12.dp),
                            containerColor = Error
                        )
                    }
                    Icon(
                        modifier = Modifier.padding(16.dp),
                        imageVector = ImageVector.vectorResource(item.icon),
                        contentDescription = item.route.path,
                        tint = if (isSelected) Color.Black else Color.White
                    )
                }
            }
        }

    }
}