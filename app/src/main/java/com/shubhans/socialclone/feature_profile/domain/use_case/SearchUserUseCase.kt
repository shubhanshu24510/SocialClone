package com.shubhans.socialclone.feature_profile.domain.use_case

import com.shubhans.socialclone.core.domain.models.UserItem
import com.shubhans.socialclone.core.domain.repository.ProfileRepository
import com.shubhans.socialclone.core.util.Resource

class SearchUserUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(query: String): Resource<List<UserItem>> {
        if(query.isBlank()) {
            return Resource.Success(data = emptyList())
        }
        return repository.searchUser(query)
    }
}