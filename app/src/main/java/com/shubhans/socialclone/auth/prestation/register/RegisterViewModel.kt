package com.shubhans.socialclone.auth.prestation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.socialclone.R
import com.shubhans.socialclone.auth.domain.model.user_cases.RegisterUseCase
import com.shubhans.socialclone.core.domain.state.StandardTextFieldState
import com.shubhans.socialclone.core.domain.state.passwordTextFieldState
import com.shubhans.socialclone.core.utils.Resourse
import com.shubhans.socialclone.core.utils.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCases: RegisterUseCase
) : ViewModel() {
    private val _emailState = mutableStateOf(StandardTextFieldState())
    val emailState: State<StandardTextFieldState> = _emailState
    private val _userNameState = mutableStateOf(StandardTextFieldState())
    val userNameState: State<StandardTextFieldState> = _userNameState
    private val _passwordState = mutableStateOf(passwordTextFieldState())
    val passwordState: State<passwordTextFieldState> = _passwordState
    private val _registerState = mutableStateOf(RegisterState())
    val registerState: State<RegisterState> = _registerState
    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    fun onEvent(event: ResisterEvent) {
        when (event) {
            is ResisterEvent.EnterEmail -> {
                _emailState.value = _emailState.value.copy(
                    text = event.value
                )
            }

            is ResisterEvent.EnterUserName -> {
                _userNameState.value = _userNameState.value.copy(
                    text = event.value
                )
            }

            is ResisterEvent.EnterPassword -> {
                _passwordState.value = _passwordState.value.copy(
                    text = event.value
                )
            }

            is ResisterEvent.TogglePasswordVisibility -> {
                _passwordState.value = _passwordState.value.copy(
                    isPasswordVisible = !passwordState.value.isPasswordVisible
                )
            }

            is ResisterEvent.Register -> {
                register()
            }

            else -> {}
        }
    }

    private fun register() {
        viewModelScope.launch {
            _userNameState.value = userNameState.value.copy(error = null)
            _emailState.value = emailState.value.copy(error = null)
            _passwordState.value = passwordState.value.copy(error = null)
            _registerState.value = RegisterState(isLoading = true)
            val registerResult = registerUseCases(
                email = emailState.value.text,
                userName = userNameState.value.text,
                password = passwordState.value.text
            )

            if (registerResult.emailError != null) {
                _emailState.value = emailState.value.copy(
                    error = registerResult.emailError
                )
            }
            if (registerResult.userNameError != null) {
                _userNameState.value = userNameState.value.copy(
                    error = registerResult.userNameError
                )
            }
            if (registerResult.passwordError != null) {
                _passwordState.value = passwordState.value.copy(
                    error = registerResult.passwordError
                )
            }

            when (registerResult.result) {
                is Resourse.Success -> {
                    _eventFlow.emit(
                        UiEvent.SnackBarEvent(UiText.StringResourse(R.string.sucess_register))
                    )
                    _registerState.value = RegisterState(isLoading = false)
                    _userNameState.value = StandardTextFieldState()
                    _emailState.value = StandardTextFieldState()
                    _passwordState.value = passwordTextFieldState()
                }

                is Resourse.Error -> {
                    _eventFlow.emit(
                        UiEvent.SnackBarEvent(registerResult.result.uiText ?: UiText.unKnownError())
                    )
                    _registerState.value = RegisterState(isLoading = false)
                }
                null ->{
                    _registerState.value = RegisterState(isLoading = false)

                }
            }

        }
    }
     sealed class UiEvent {
        data class SnackBarEvent(val uiText: UiText) : UiEvent()
    }
}



