package com.shubhans.socialclone.feature_post.prestation.mainFeed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.shubhans.socialclone.R
import com.shubhans.socialclone.domain.model.Post
import com.shubhans.socialclone.prestation.componet.Post
import com.shubhans.socialclone.prestation.componet.StandardTopToolBar
import com.shubhans.socialclone.utils.Screen
import kotlinx.coroutines.launch


@Composable
fun MainFeedScreen(
    navController: NavController,
    viewModel: MainFeedViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState
) {
    val posts =viewModel.posts.collectAsLazyPagingItems()
    val state =viewModel.state.value
    val scope = rememberCoroutineScope()
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
        Box(modifier = Modifier.fillMaxSize()){
            if(state.isLoadingFirstTime){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            LazyColumn {
                items(posts) {post->
                    if (post != null) {
                        Post(
                            post = Post(
                                username = post.username?:"",
                                imageUrl = post.imageUrl?:"",
                                profilePictureUrl = post.profilePictureUrl?:"",
                                likeCount = post.likeCount ?:0,
                                description = post.description?:"",
                                commentCount = post.commentCount ?:0,
                            )
                        ) {
                            navController.navigate(Screen.PostDetailsScreen.route)
                        }
                    }

                }
                item {
                    if(state.isLoadingNewPost){
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.BottomCenter)
                        )
                    }
                }
                posts.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            viewModel.onEvent(MainFeedEvent.LoadPage)
                        }
                        loadState.append is LoadState.Loading -> {
                            viewModel.onEvent(MainFeedEvent.LoadMorePost)
                        }
                        loadState.append is LoadState.NotLoading -> {
                            viewModel.onEvent(MainFeedEvent.LoadPage)
                        }
                        loadState.append is LoadState.Error -> {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Error"
                                )
                            }
                        }
                    }
                }

            }
        }

            }
        }

