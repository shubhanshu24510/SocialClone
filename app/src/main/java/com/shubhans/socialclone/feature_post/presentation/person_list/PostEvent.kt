package com.shubhans.socialclone.feature_post.presentation.person_list

import com.shubhans.socialclone.core.util.Event

sealed class PostEvent : Event() {
    object OnLiked: PostEvent()
}