package com.carmedia2p0.capture.di

import com.carmedia2p0.capture.data.network.api.CarmediaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {

    @Provides
    @Singleton
    fun provideUserService(@com.carmedia2p0.capture.di.CarMediaApi retrofit: Retrofit): CarmediaApi {
        return retrofit.create(CarmediaApi::class.java)
    }
}
