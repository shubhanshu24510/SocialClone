package com.shubhans.socialclone.feature_post.prestation.mainFeed

sealed class MainFeedEvent {
    object LoadMorePost:MainFeedEvent()
    object LoadPage:MainFeedEvent()

}