package com.shubhans.socialclone.core.domain.use_case

import com.shubhans.socialclone.core.util.SimpleResource
import com.shubhans.socialclone.feature_post.domain.repository.PostRepository

class DeletePost(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): SimpleResource {
        return repository.deletePost(postId)
    }
}