package com.shubhans.socialclone.auth.domain.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.shubhans.socialclone.R
import com.shubhans.socialclone.auth.data.dto.request.CreateAccountRequest
import com.shubhans.socialclone.auth.data.remote.AuthAPi
import com.shubhans.socialclone.core.utils.Resourse
import com.shubhans.socialclone.core.utils.SimpleResourse
import com.shubhans.socialclone.core.utils.UiText
import java.io.IOException
class AuthRepositoryImp(
    private val api: AuthAPi,
  //  private val sharedPreferences: SharedPreferences
) : AuthRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun register(
        email: String, userName: String, password: String
    ): SimpleResourse {
        val request = CreateAccountRequest(email, userName, password)
        return try {
            val response = api.register(request)
            if (response.successful) {
                Resourse.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resourse.Error(UiText.DynamicResourse(msg))
                } ?: Resourse.Error(UiText.StringResourse(R.string.unknown_Error))
            }
        } catch (e: IOException) {
            Resourse.Error(
                uiText = UiText.StringResourse(R.string.error_could_not_found_server)
            )
        } catch (e: HttpException) {
            Resourse.Error(
                uiText = UiText.StringResourse(R.string.some_wrong)
            )
        }
    }
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun authenticate(): SimpleResourse {
        return try {
            api.authenticate()
            Resourse.Success(Unit)
        } catch (e: IOException) {
            Resourse.Error(
                uiText = UiText.StringResourse(R.string.error_could_not_found_server)
            )
        } catch (e: HttpException) {
            Resourse.Error(
                uiText = UiText.StringResourse(R.string.some_wrong)
            )
        }
    }
}

