package com.shubhans.socialclone.feature_activity.presentation

sealed class ActivityEvent {
    data class ClickedOnUser(val userId: String): ActivityEvent()
    data class ClickedOnParent(val parentId: String): ActivityEvent()
}
