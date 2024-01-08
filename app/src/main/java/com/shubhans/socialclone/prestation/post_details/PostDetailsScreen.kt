package com.shubhans.socialclone.prestation.post_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shubhans.socialclone.R
import com.shubhans.socialclone.domain.model.Comment
import com.shubhans.socialclone.domain.model.Post
import com.shubhans.socialclone.prestation.componet.ActionButton
import com.shubhans.socialclone.prestation.componet.StandardTopToolBar
import com.shubhans.socialclone.ui.theme.MediumGray
import com.shubhans.socialclone.ui.theme.ProfilePictureSizeExtraSmall
import com.shubhans.socialclone.ui.theme.ProfilePictureSizeMedium
import com.shubhans.socialclone.ui.theme.ProfilePictureSizeSmall
import com.shubhans.socialclone.ui.theme.SpaceLarge
import com.shubhans.socialclone.ui.theme.SpaceMedium
import com.shubhans.socialclone.ui.theme.Spacesmall
import com.shubhans.socialclone.ui.theme.shapes

@Composable
fun PostDetailsScreen(
    navController: NavController,
    post: Post
) {

    Column(modifier = Modifier.fillMaxSize()) {
        StandardTopToolBar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            showBackArrow = true,
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    Spacer(modifier = Modifier.height(SpaceMedium))
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(shape = shapes.medium)
                                .offset(y = ProfilePictureSizeSmall / 2f)
                                .background(MediumGray)
                                .shadow(5.dp)
                        ) {
                            Image(
                                painterResource(id = R.drawable.himalayamountain),
                                contentDescription = "post image",
                                modifier = Modifier.fillMaxWidth()
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(SpaceLarge)
                            ) {
                                ActionButton(
                                    modifier = Modifier.fillMaxWidth(),
                                    onLikeClick = {

                                    },
                                    onCommentClick = {

                                    },
                                    onshareClick = {

                                    },
                                    username = "shubhanshu2451"
                                ) {

                                }
                                Spacer(modifier = Modifier.height(Spacesmall))
                                Text(
                                    text = post.description,
                                    style = MaterialTheme.typography.body2
                                )

                                Spacer(modifier = Modifier.height(SpaceMedium))
                                Text(
                                    text = stringResource(
                                        id = R.string.liked_by_x_people,
                                        post.likeCount
                                    ),
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.body2
                                )
                            }
                        }
                        Image(
                            painterResource(id = R.drawable.profile_picture),
                            contentDescription = "profile Image",
                            modifier = Modifier
                                .size(ProfilePictureSizeMedium)
                                .clip(CircleShape)
                                .align(Alignment.TopCenter)
                        )
                    }

                }
                Spacer(modifier = Modifier.height(SpaceLarge))
            }

            items(13) {
                Comment(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = SpaceLarge,
                            vertical = Spacesmall
                        ),
                    comment = Comment(
                        username = "shubhanshu2451$it",
                        comment = "Lorem ipsum dolor sit amet, consetetur, asdfadsf \n" + "diam nonumy eirmod tempor invidunt ut fda fdsa \n" + "magna aliquyam erat, sed diam voluptua "
                    )

                ) {

                }
            }


        }
    }

}


@Composable
fun Comment(
    modifier: Modifier = Modifier,
    comment: Comment = Comment(),
    onLikedClicked: (Boolean) -> Unit = {}
) {
    Card(
        modifier = modifier,
        elevation = 5.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_picture),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(ProfilePictureSizeExtraSmall)
                    )
                    Spacer(modifier = Modifier.height(Spacesmall))
                    Text(
                        text = comment.username,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.onBackground
                    )
                }
                Text(
                    text = "2 days ago",
                    style = MaterialTheme.typography.body2
                )

            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = comment.comment,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.weight(9f)
                )
                Spacer(modifier = Modifier.height(SpaceMedium))

                IconButton(
                    onClick = {
                        onLikedClicked(comment.isLiked)

                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = if (comment.isLiked) {
                            stringResource(id = R.string.un_like)
                        } else stringResource(id = R.string.li_ke)
                    )
                }
            }
            Spacer(modifier = Modifier.height(SpaceMedium))

            Text(
                text = stringResource(
                    id = R.string.liked_by_x_people,
                    comment.likeCount
                ),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground
            )

        }

    }

}