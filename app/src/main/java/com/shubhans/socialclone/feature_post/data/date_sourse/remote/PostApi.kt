package com.shubhans.socialclone.feature_post.data.date_sourse.remote

import com.shubhans.socialclone.domain.model.Post
import retrofit2.http.GET
import retrofit2.http.Query
interface PostApi {
    @GET("api/post/get")
    suspend fun getPostsForFollows(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<Post>

    companion object{
        const val BASE_URL = "http://10.0.2.2:8001/"
    }
}