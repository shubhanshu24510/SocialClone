package com.shubhans.socialclone.auth.domain.model.user_cases

import com.shubhans.socialclone.auth.domain.model.registerResult
import com.shubhans.socialclone.auth.domain.repository.AuthRepository
import com.shubhans.socialclone.utils.ValidationUtils

class RegisterUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        userName: String,
        password: String
    ): registerResult {
        val emailError = ValidationUtils.validEmail(email)
        val userNameError = ValidationUtils.validUserName(userName)
        val passwordError = ValidationUtils.validPassword(password)

        if (emailError != null || passwordError != null || userNameError != null) {
            return registerResult(
                emailError = emailError,
                userNameError = userNameError,
                passwordError = passwordError
            )
        }
        val result = repository.register(email.trim(), userName.trim(), password.trim())
        return registerResult(
            result = result
        )
    }
}