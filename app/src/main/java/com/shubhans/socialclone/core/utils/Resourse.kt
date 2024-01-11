package com.shubhans.socialclone.core.utils

sealed class Resourse<T>(val data: T? = null, val uiText: UiText? = null) {
    class Success<T>(data: T?) : Resourse<T>(data)
    class Error<T>(uiText: UiText, data: T? = null) : Resourse<T>(data, uiText)

}
typealias SimpleResourse = Resourse<Unit>

