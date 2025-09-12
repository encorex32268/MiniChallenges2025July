package com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges

import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lihan.minichallenges2025july.R
import com.lihan.minichallenges2025july.fonts.urbanist
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme
import com.lihan.minichallenges2025july.ui.theme.OnSurfaceAlt
import com.lihan.minichallenges2025july.ui.theme.OnSurfaceVar
import com.lihan.minichallenges2025july.ui.theme.Primary
import com.lihan.minichallenges2025july.ui.theme.Surface50


@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    leadingIcon: @Composable (() -> Unit)?=null,
    textStyle: TextStyle = TextStyle(
        fontFamily = urbanist,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    modifier: Modifier = Modifier,
) {

    Button(
        modifier = modifier.widthIn(min = 240.dp),
        onClick = onClick,
        shape = RoundedCornerShape(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary,
            contentColor = OnSurfaceAlt
        )
    ) {
        Row(
            modifier = Modifier.padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            leadingIcon?.invoke()
            Text(text = text, style = textStyle)
        }
    }

}


@Composable
fun CustomOutlineButton(
    onClick: () -> Unit,
    text: String,
    isSelected: Boolean = false,
    leadingIcon: @Composable (() -> Unit)?=null,
    textStyle: TextStyle = TextStyle(
        fontFamily = urbanist,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        modifier = modifier.widthIn(min = 240.dp),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Surface50,
            contentColor = if (isSelected) OnSurfaceVar else Primary
        ),
        border = BorderStroke(1.dp, if (isSelected) OnSurfaceVar else Primary),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            leadingIcon?.invoke()
            Text(text = text, style = textStyle)
        }
    }

}

@Composable
@Preview
fun CustomButtonPreview() {
    MiniChallenges2025JulyTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
            CustomButton(
                onClick = {},
                text = "Text"
            )
            CustomButton(
                onClick = {},
                text = "Text",
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.message),
                        contentDescription = "Message"
                    )
                }
            )
        }
    }
}

@Composable
@Preview
fun CustomOutlineButtonPreview() {
    MiniChallenges2025JulyTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
            CustomOutlineButton(
                onClick = {},
                text = "Text"
            )
            CustomOutlineButton(
                onClick = {},
                text = "Text",
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.phone),
                        contentDescription = "Phone"
                    )
                }
            )

            CustomOutlineButton(
                isSelected = true,
                onClick = {},
                text = "Text",
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.phone),
                        contentDescription = "Phone"
                    )
                }
            )

        }
    }
}