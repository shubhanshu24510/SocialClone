package com.shubhans.socialclone.feature_post.prestation.create_Post

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shubhans.socialclone.R
import com.shubhans.socialclone.core.domain.state.StandardTextFieldState
import com.shubhans.socialclone.prestation.componet.StandardTextField
import com.shubhans.socialclone.prestation.componet.StandardTopToolBar
import com.shubhans.socialclone.ui.theme.SpaceLarge
import com.shubhans.socialclone.ui.theme.SpaceMedium
import com.shubhans.socialclone.ui.theme.Spacesmall

@Composable
fun CreatePostScreen(
    navController: NavController,
    viewModel: CreatePostViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        StandardTopToolBar(
            navController = navController,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.create_a_new_post),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },
            navActions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceLarge)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onBackground,
                        shape = MaterialTheme.shapes.medium
                    )
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onBackground
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                modifier = Modifier.fillMaxWidth(),
                text = viewModel.descriptionState.value.text,
                hint = stringResource(id = R.string.make_description),
//                error = when (viewModel.descriptionState.value.error) {
//                    is Post.FiledEmpty -> {
//                        stringResource(id = R.string.this_field_cant_be_empty)
//                    }
//
//                    else -> {}
//                },
                singleLine = false,
                maxLines = 5
            ) {
                viewModel.setdescriptionState(StandardTextFieldState())
            }
            Spacer(modifier = Modifier.height(SpaceLarge))
            Button(modifier = Modifier.align(Alignment.End),
                onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.post),
                    color = MaterialTheme.colors.onPrimary
                )
                Spacer(modifier = Modifier.width(Spacesmall))
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null
                )
            }
        }
    }
}