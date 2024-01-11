package com.shubhans.socialclone.feature_post.prestation.mainFeed

data class MainFeedState(
    val isLoadingFirstTime :Boolean =true,
    val isLoadingNewPost :Boolean =false,
    val page:Int =0
)