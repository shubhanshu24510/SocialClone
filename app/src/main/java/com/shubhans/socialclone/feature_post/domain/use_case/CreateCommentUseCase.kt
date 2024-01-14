package com.shubhans.socialclone.feature_post.domain.use_case

import com.shubhans.socialclone.R
import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.core.util.SimpleResource
import com.shubhans.socialclone.core.util.UiText
import com.shubhans.socialclone.feature_post.domain.repository.PostRepository

class CreateCommentUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String, comment: String): SimpleResource {
        if(comment.isBlank()) {
            return Resource.Error(UiText.StringResource(R.string.error_empty))
        }
        if(postId.isBlank()) {
            return Resource.Error(UiText.unknownError())
        }
        return repository.createComment(postId, comment)
    }
}