package com.shubhans.socialclone.auth.domain.repository

import com.shubhans.socialclone.core.utils.SimpleResourse

interface AuthRepository {
    suspend fun register(
        email: String,
        userName: String,
        password: String
    ): SimpleResourse
//    suspend fun logIn(
//        email: String,
//        password: String
//    ): SimpleResourse
//
   suspend fun authenticate(): SimpleResourse
}