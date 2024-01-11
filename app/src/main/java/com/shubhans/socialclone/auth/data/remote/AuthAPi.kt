package com.shubhans.socialclone.auth.data.remote

import com.shubhans.socialclone.auth.data.dto.request.CreateAccountRequest
import com.shubhans.socialclone.core.data.dto.response.BasicAPiResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPi {
    @POST("/api/user/create")
    suspend fun register(@Body request: CreateAccountRequest): BasicAPiResponse<Unit>

    @POST("/api/user/authenticate")
    suspend fun authenticate()

    companion object {
        // const val BASE_URL = "http://127.0.2.2:8001/"
        const val BASE_URL = "http://10.0.2.2:8001/"
        //  const val BASE_URL = "http://127.0.0.1:8001/"
    }
}