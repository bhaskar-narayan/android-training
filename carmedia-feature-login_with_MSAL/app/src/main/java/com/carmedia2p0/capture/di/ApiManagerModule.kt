package com.carmedia2p0.capture.di

import com.carmedia2p0.capture.data.network.api.CarmediaApi
import com.carmedia2p0.capture.data.network.retrofitmanager.ApiManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiManagerModule {
    @Singleton
    @Provides
    fun providesApiManager(api: CarmediaApi): ApiManager {
        return ApiManager(api)
    }
}
