package com.shubhans.socialclone.feature_post.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shubhans.socialclone.domain.model.Post
import com.shubhans.socialclone.feature_post.data.date_sourse.remote.PostApi
import com.shubhans.socialclone.utils.Constants
import okio.IOException
import retrofit2.HttpException

class PostSourse(
    private val api: PostApi
):PagingSource<Int,Post>() {
    private var currentPage =0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        return try {
            val nextPage =params.key ?:currentPage
            val posts =api.getPostsForFollows(
                page = nextPage,
                pageSize = Constants.PAGE_SIZE_POSTS
            )
            LoadResult.Page(
                data = posts,
                prevKey = if (nextPage == 0) null else nextPage -1 ,
                nextKey = if (posts.isEmpty()) null else currentPage
            ).also { currentPage ++ }
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Post>): Int? = state.anchorPosition

}
