package com.shubhans.socialclone.feature_post.domain.use_case

import com.shubhans.socialclone.core.domain.models.Post
import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.feature_post.domain.repository.PostRepository

class GetPostDetailsUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): Resource<Post> {
        return repository.getPostDetails(postId)
    }
}