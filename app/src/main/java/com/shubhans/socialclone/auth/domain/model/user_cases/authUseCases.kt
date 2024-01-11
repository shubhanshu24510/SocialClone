package com.shubhans.socialclone.auth.domain.model.user_cases

import com.shubhans.socialclone.auth.domain.repository.AuthRepository
import com.shubhans.socialclone.core.utils.SimpleResourse

class AuthUseCases(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(): SimpleResourse {
        return repository.authenticate()
    }
}