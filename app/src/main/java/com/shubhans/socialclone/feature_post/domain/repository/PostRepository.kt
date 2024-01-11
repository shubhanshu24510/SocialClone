package com.shubhans.socialclone.feature_post.domain.repository

import androidx.paging.PagingData
import com.shubhans.socialclone.core.utils.Resourse
import com.shubhans.socialclone.domain.model.Post
import com.shubhans.socialclone.utils.Constants
import kotlinx.coroutines.flow.Flow

interface PostRepository {
   val posts:Flow<PagingData<Post>>
}