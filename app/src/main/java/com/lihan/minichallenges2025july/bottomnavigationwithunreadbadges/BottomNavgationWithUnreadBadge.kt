@file:OptIn(ExperimentalMaterial3Api::class)

package com.lihan.minichallenges2025july.bottomnavigationwithunreadbadges

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.lihan.minichallenges2025july.R
import com.lihan.minichallenges2025july.fonts.urbanist
import com.lihan.minichallenges2025july.ui.theme.MiniChallenges2025JulyTheme

@Composable
fun BottomNavigationWithUnreadBadge(
    state: BottomNavigationWithUnreadBadgeState,
    onAction: (BottomNavigationWithUnreadBadgeAction) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = state.selectedRoute.path,
                        style = TextStyle(
                            fontFamily = urbanist,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp
                        )
                    )
                }
            )
        },
        bottomBar = {
           CustomNavigationBottomBar(
               currentRoute = state.selectedRoute,
               onBottomItemClick = { item ->
                   onAction(BottomNavigationWithUnreadBadgeAction.OnBottomItemClick(item))
               },
               bottomItems = state.bottomItems

           )
        }
    ) { innerPadding ->
        NavDisplay(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            onBack = {
                onAction(BottomNavigationWithUnreadBadgeAction.OnBackClick)
            },
            backStack = state.backstack,
            entryProvider = { route ->
                when(route){
                    is Route.Chats -> NavEntry(route) {

                    }
                    is Route.Calls -> NavEntry(route){

                    }
                    is Route.Settings -> NavEntry(route){
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            CustomButton(
                                onClick = {
                                    onAction(BottomNavigationWithUnreadBadgeAction.OnMissACallClick)
                                },
                                text = "Miss a Call",
                                leadingIcon = {
                                    Icon(
                                        imageVector = ImageVector.vectorResource(R.drawable.phone),
                                        contentDescription = "Phone"
                                    )
                                }
                            )
                            CustomButton(
                                onClick = {
                                    onAction(BottomNavigationWithUnreadBadgeAction.OnSendMessageClick)
                                },
                                text = "Send Message",
                                leadingIcon = {
                                    Icon(
                                        imageVector = ImageVector.vectorResource(R.drawable.message),
                                        contentDescription = "Message"
                                    )
                                }
                            )
                            CustomOutlineButton(
                                onClick = {
                                    onAction(BottomNavigationWithUnreadBadgeAction.OnMarkAsReadClick)
                                },
                                text = "Mark as Read",
                                leadingIcon = {
                                    Icon(
                                        imageVector = ImageVector.vectorResource(R.drawable.read),
                                        contentDescription = "Read"
                                    )
                                }
                            )
                        }
                    }
                }


            }
        )
    }
}


@Composable
@Preview(showSystemUi = true)
fun BottomNavigationWithUnreadBadgePreview() {
    MiniChallenges2025JulyTheme {
        BottomNavigationWithUnreadBadge(
            state = BottomNavigationWithUnreadBadgeState(),
            onAction = {}
        )
    }
}