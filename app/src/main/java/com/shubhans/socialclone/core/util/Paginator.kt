package com.shubhans.socialclone.core.util

interface Paginator<T> {

    suspend fun loadNextItems()
}