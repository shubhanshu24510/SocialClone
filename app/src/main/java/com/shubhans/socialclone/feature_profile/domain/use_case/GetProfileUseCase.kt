package com.shubhans.socialclone.feature_profile.domain.use_case

import com.shubhans.socialclone.core.domain.repository.ProfileRepository
import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.feature_profile.domain.model.Profile

class GetProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String): Resource<Profile> {
        return repository.getProfile(userId)
    }
}