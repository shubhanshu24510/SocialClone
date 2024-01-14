package com.shubhans.socialclone.feature_post.domain.use_case

import com.shubhans.socialclone.core.domain.models.UserItem
import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.feature_post.domain.repository.PostRepository

class GetLikesForParentUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(parentId: String): Resource<List<UserItem>> {
        return repository.getLikesForParent(parentId)
    }
}