package com.shubhans.socialclone.feature_post.prestation.mainFeed

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.shubhans.socialclone.feature_post.domain.use_cases.PostuseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFeedViewModel @Inject constructor(
    private val postuseCases: PostuseCases
) : ViewModel() {
    private val _state = mutableStateOf(MainFeedState())
    val state:State<MainFeedState> =_state

    val posts =postuseCases.getFollowsForUserCases()
        .cachedIn(viewModelScope)
    fun onEvent(event:MainFeedEvent){
        when(event){
            is MainFeedEvent.LoadMorePost ->{
                _state.value =state.value.copy(
                    isLoadingNewPost = true
                )
            }
            is MainFeedEvent.LoadPage ->{
                _state.value =state.value.copy(
                    isLoadingNewPost = false,
                    isLoadingFirstTime = false
                )
            }
        }
    }
}


