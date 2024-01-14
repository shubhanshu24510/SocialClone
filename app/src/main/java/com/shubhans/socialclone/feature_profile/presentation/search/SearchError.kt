package com.shubhans.socialclone.feature_profile.presentation.search

import com.shubhans.socialclone.core.util.Error
import com.shubhans.socialclone.core.util.UiText

data class SearchError(
    val message: UiText
): Error()
