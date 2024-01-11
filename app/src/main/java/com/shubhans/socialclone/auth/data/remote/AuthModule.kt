package com.shubhans.socialclone.auth.data.remote

import com.shubhans.socialclone.auth.domain.model.user_cases.AuthUseCases
import com.shubhans.socialclone.auth.domain.model.user_cases.RegisterUseCase
import com.shubhans.socialclone.auth.domain.repository.AuthRepository
import com.shubhans.socialclone.auth.domain.repository.AuthRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }
    @Provides
    @Singleton
    fun provideAuthAPi(client: OkHttpClient): AuthAPi {
        return Retrofit.Builder().baseUrl(AuthAPi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthAPi::class.java)
    }
    @Provides
    @Singleton
    fun provideAuthRepository(aPi: AuthAPi): AuthRepository {
        return AuthRepositoryImp(aPi)
    }
    @Provides
    @Singleton
    fun provideRegistrationUseCase(repository: AuthRepository): RegisterUseCase {
        return RegisterUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideAuthenticationUsecase(repository: AuthRepository): AuthUseCases {
        return AuthUseCases(repository)
    }
}

