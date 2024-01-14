package com.shubhans.socialclone.core.presentation.util

import com.shubhans.socialclone.core.util.Event
import com.shubhans.socialclone.core.util.UiText

sealed class UiEvent: Event() {
    data class ShowSnackbar(val uiText: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp : UiEvent()
    object OnLogin: UiEvent()
}