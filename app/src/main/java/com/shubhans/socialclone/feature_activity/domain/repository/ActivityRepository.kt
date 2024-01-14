package com.shubhans.socialclone.feature_activity.domain.repository

import androidx.paging.PagingData
import com.shubhans.socialclone.core.domain.models.Activity
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {

    val activities: Flow<PagingData<Activity>>
}