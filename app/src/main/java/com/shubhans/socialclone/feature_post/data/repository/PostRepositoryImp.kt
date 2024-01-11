package com.shubhans.socialclone.feature_post.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.shubhans.socialclone.domain.model.Post
import com.shubhans.socialclone.feature_post.data.date_sourse.remote.PostApi
import com.shubhans.socialclone.feature_post.data.paging.PostSourse
import com.shubhans.socialclone.feature_post.domain.repository.PostRepository
import com.shubhans.socialclone.utils.Constants
import kotlinx.coroutines.flow.Flow

class PostRepositoryImp(
    private val api: PostApi
):PostRepository{
    override val posts:Flow<PagingData<Post>>
        get() = Pager(PagingConfig(pageSize = Constants.PAGE_SIZE_POSTS)){
            PostSourse(api)
        }.flow

}