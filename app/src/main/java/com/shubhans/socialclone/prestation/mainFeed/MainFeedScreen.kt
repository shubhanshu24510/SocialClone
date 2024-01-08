package com.shubhans.socialclone.prestation.mainFeed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.shubhans.socialclone.R
import com.shubhans.socialclone.domain.model.Post
import com.shubhans.socialclone.prestation.componet.Post
import com.shubhans.socialclone.prestation.componet.StandardTopToolBar
import com.shubhans.socialclone.utils.Screen


@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardTopToolBar(
            modifier = Modifier.fillMaxWidth(),
            navController = navController,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            navActions = {
                IconButton(onClick = { navController.navigate(Screen.SearchScreen.route) }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onBackground
                    )

                }
            }
        )
        Post(
            post = Post(
                username = "shubhans2451",
                imageUrl = "",
                profilePictureUrl = "",
                likeCount = 53,
                description = "Absolutely adore Quito! Nestled amid stunning mountains, this city captivates with its rich history",
                commentCount = 13,
            )
        ) {
            navController.navigate(Screen.PostDetailsScreen.route)
        }
    }
}
