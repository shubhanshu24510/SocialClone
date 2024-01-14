package com.shubhans.socialclone.core.domain.models

import com.shubhans.socialclone.feature_activity.domain.ActivityType

data class Activity(
    val userId: String,
    val parentId: String,
    val username: String,
    val activityType: ActivityType,
    val formattedTime: String,
)
