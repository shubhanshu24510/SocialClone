package com.shubhans.socialclone.feature_activity.presentation

import com.shubhans.socialclone.core.domain.models.Activity

data class ActivityState(
    val activities: List<Activity> = emptyList(),
    val isLoading: Boolean = false,
)
