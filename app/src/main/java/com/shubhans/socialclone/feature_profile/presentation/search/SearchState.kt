package com.shubhans.socialclone.feature_profile.presentation.search

import com.shubhans.socialclone.core.domain.models.UserItem

data class SearchState(
    val userItems: List<UserItem> = emptyList(),
    val isLoading: Boolean = false
)
