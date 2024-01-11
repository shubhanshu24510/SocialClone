package com.shubhans.socialclone.feature_post.domain.use_cases

import androidx.paging.PagingData
import com.shubhans.socialclone.domain.model.Post
import com.shubhans.socialclone.feature_post.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetFollowsForUserCases(
    private val repository: PostRepository
) {
     operator fun invoke(): Flow<PagingData<Post>> {
        return repository.posts
    }
}