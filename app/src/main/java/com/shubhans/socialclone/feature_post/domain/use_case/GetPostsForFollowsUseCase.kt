package com.shubhans.socialclone.feature_post.domain.use_case

import com.shubhans.socialclone.core.domain.models.Post
import com.shubhans.socialclone.core.util.Constants
import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.feature_post.domain.repository.PostRepository

class GetPostsForFollowsUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
        page: Int,
        pageSize: Int = Constants.DEFAULT_PAGE_SIZE
    ): Resource<List<Post>> {
        return repository.getPostsForFollows(page, pageSize)
    }
}