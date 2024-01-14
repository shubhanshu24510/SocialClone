package com.shubhans.socialclone.feature_post.domain.use_case

import com.shubhans.socialclone.core.domain.models.Comment
import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.feature_post.domain.repository.PostRepository

class GetCommentsForPostUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): Resource<List<Comment>> {
        return repository.getCommentsForPost(postId)
    }
}