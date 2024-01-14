package com.shubhans.socialclone.core.domain.repository

import android.net.Uri
import com.shubhans.socialclone.core.domain.models.Post
import com.shubhans.socialclone.core.domain.models.UserItem
import com.shubhans.socialclone.core.util.Constants
import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.core.util.SimpleResource
import com.shubhans.socialclone.feature_profile.domain.model.Profile
import com.shubhans.socialclone.feature_profile.domain.model.Skill
import com.shubhans.socialclone.feature_profile.domain.model.UpdateProfileData

interface ProfileRepository {

    suspend fun getPostsPaged(
        page: Int = 0,
        pageSize: Int = Constants.DEFAULT_PAGE_SIZE,
        userId: String
    ): Resource<List<Post>>

    suspend fun getProfile(userId: String): Resource<Profile>

    suspend fun updateProfile(
        updateProfileData: UpdateProfileData,
        bannerImageUri: Uri?,
        profilePictureUri: Uri?
    ): SimpleResource

    suspend fun getSkills(): Resource<List<Skill>>

    suspend fun searchUser(query: String): Resource<List<UserItem>>

    suspend fun followUser(userId: String): SimpleResource

    suspend fun unfollowUser(userId: String): SimpleResource

    fun logout()
}