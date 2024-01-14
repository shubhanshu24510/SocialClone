package com.shubhans.socialclone.feature_auth.domain.use_case

import com.shubhans.socialclone.core.util.SimpleResource
import com.shubhans.socialclone.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(): SimpleResource {
        return repository.authenticate()
    }
}