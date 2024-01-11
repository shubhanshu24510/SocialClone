package com.shubhans.socialclone.domain.di

import com.shubhans.socialclone.feature_post.data.date_sourse.remote.PostApi
import com.shubhans.socialclone.feature_post.data.repository.PostRepositoryImp
import com.shubhans.socialclone.feature_post.domain.repository.PostRepository
import com.shubhans.socialclone.feature_post.domain.use_cases.GetFollowsForUserCases
import com.shubhans.socialclone.feature_post.domain.use_cases.PostuseCases
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
object PostModule {


    @Provides
    @Singleton
    fun providePostApi(clint:OkHttpClient):PostApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(PostApi.BASE_URL)
            .client(clint)
            .build()
            .create(PostApi::class.java)
    }
    @Provides
    @Singleton
    fun providePostRepository(api:PostApi):PostRepository{
        return PostRepositoryImp(api)
    }
    @Provides
    @Singleton
    fun providePostUSeCase(repository: PostRepository):PostuseCases{
        return PostuseCases(
            getFollowsForUserCases = GetFollowsForUserCases(repository)
        )
    }
}