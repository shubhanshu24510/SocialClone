package com.shubhans.socialclone.auth.prestation.register

sealed class ResisterEvent{
    data class EnterUserName(val value:String): ResisterEvent()
    data class EnterEmail(val value:String): ResisterEvent()
    data class EnterPassword(val value:String): ResisterEvent()
    object TogglePasswordVisibility: ResisterEvent()
    object Register: ResisterEvent()
}
