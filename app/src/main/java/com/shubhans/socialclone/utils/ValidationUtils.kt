package com.shubhans.socialclone.utils

import android.util.Patterns
import com.shubhans.socialclone.auth.domain.model.AuthError
object ValidationUtils{
    fun validEmail(email:String): AuthError? {
        val trimEmail =email.trim()
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return AuthError.InvalidEmail
        }
        if(trimEmail.isBlank()){
            return AuthError.FieldEmpty
        }
        return null
    }
    fun validUserName(userName:String): AuthError? {
        val trimUsername =userName.trim()
        if(trimUsername.length < Constants.MIN_USERNAME_LENGTH){
            return AuthError.InputTooShort
        }
        if(trimUsername.isBlank()){
            return AuthError.FieldEmpty
        }
        return null
    }

    fun validPassword(password:String): AuthError? {
        val capitalLettersInPassword = password.any { it.isUpperCase() }
        val numberInPassword = password.any { it.isDigit() }
        if (!capitalLettersInPassword || !numberInPassword) {
            return AuthError.InvalidPassword
        }
        if(password.length < Constants.MIN_PASSWORD_LENGTH){
            return AuthError.InputTooShort
        }
        if(password.isBlank()){
            return AuthError.FieldEmpty
        }
        return null
    }
}
