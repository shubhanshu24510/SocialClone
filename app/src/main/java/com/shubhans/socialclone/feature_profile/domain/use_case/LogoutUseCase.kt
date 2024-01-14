package com.shubhans.socialclone.feature_profile.domain.use_case

import com.shubhans.socialclone.core.domain.repository.ProfileRepository

class LogoutUseCase(
    private val repository: ProfileRepository
) {

    operator fun invoke() {
        repository.logout()
    }
}