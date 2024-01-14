package com.shubhans.socialclone.feature_profile.domain.use_case

import com.shubhans.socialclone.core.domain.models.Post
import com.shubhans.socialclone.core.domain.repository.ProfileRepository
import com.shubhans.socialclone.core.util.Resource

class GetPostsForProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String, page: Int): Resource<List<Post>> {
        return repository.getPostsPaged(
            userId = userId,
            page = page
        )
    }
}