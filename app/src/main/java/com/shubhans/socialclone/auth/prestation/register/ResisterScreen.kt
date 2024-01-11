package com.shubhans.socialclone.auth.prestation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shubhans.socialclone.R
import com.shubhans.socialclone.auth.domain.model.AuthError
import com.shubhans.socialclone.core.utils.asString
import com.shubhans.socialclone.prestation.componet.StandardTextField
import com.shubhans.socialclone.ui.theme.SpaceLarge
import com.shubhans.socialclone.ui.theme.SpaceMedium
import com.shubhans.socialclone.utils.Constants
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RegisterScreen(
    navController: NavController,
    scaffoldState:ScaffoldState,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val userNameState =viewModel.userNameState.value
    val emailState =viewModel.emailState.value
    val passwordState =viewModel.passwordState.value
    val registerState =viewModel.registerState.value
    val context = LocalContext.current

    LaunchedEffect(key1 =true){
        viewModel.eventFlow.collectLatest {event->
        when(event){
            is RegisterViewModel.UiEvent.SnackBarEvent ->{
                scaffoldState.snackbarHostState.showSnackbar(
                    event.uiText.asString(context),
                    duration = SnackbarDuration.Long
                )
            }

        }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 50.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
        ) {
            Text(
                text = stringResource(id = R.string.register),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = emailState.text,
                onValueChange = {
                    viewModel.onEvent(ResisterEvent.EnterEmail(it))
                },
                error = when (emailState.error) {
                   is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    AuthError.InvalidEmail -> {
                        stringResource(id = R.string.not_a_valid_email)
                    }
                    else -> ""
                },
                keyboardType = KeyboardType.Email,
                hint = stringResource(id = R.string.email)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = userNameState.text,
                onValueChange = {
                    viewModel.onEvent(ResisterEvent.EnterUserName(it))
                },
                error = when (viewModel.userNameState.value.error) {
                    is AuthError.FieldEmpty ->{
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                   is AuthError.InputTooShort ->{
                        stringResource(id = R.string.input_too_short, Constants.MIN_USERNAME_LENGTH)
                    }

                    else ->""
                },
                hint = stringResource(id = R.string.Username)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = passwordState.text,
                onValueChange = {
                    viewModel.onEvent(ResisterEvent.EnterPassword(it))
                },
                hint = stringResource(id = R.string.password_hint),
                keyboardType = KeyboardType.Password,
                error = when (passwordState.error) {
                  is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    is AuthError.InputTooShort -> {
                        stringResource(id =R.string.input_too_short, Constants.MIN_PASSWORD_LENGTH)
                    }
                    is AuthError.InvalidPassword -> {
                        stringResource(id = R.string.invalid_password)
                    }
                    else ->""
                },
                isPasswordVisible = passwordState.isPasswordVisible,
                onPasswordToggleClick = {
                    viewModel.onEvent(ResisterEvent.TogglePasswordVisibility)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                    viewModel.onEvent(ResisterEvent.Register)
                },

                modifier = Modifier
                    .align(Alignment.End)
                , enabled = !registerState.isLoading
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            if(registerState.isLoading){
                CircularProgressIndicator()
            }
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id =R.string.already_have_an_account))
                append(" ")
                val signUpText = stringResource(id = R.string.sign_up)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary
                    )
                ) {
                    append(signUpText)
                }
            },
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}