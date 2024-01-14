package com.shubhans.socialclone.feature_post.presentation.person_list

import com.shubhans.socialclone.core.domain.models.UserItem

data class PersonListState(
    val users: List<UserItem> = emptyList(),
    val isLoading: Boolean = false
)
