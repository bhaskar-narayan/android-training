package com.carmedia2p0.capture.di

import android.content.Context
import com.carmedia2p0.capture.ui.main.msal.B2CConfiguration
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {
    @Singleton
    @Provides
    fun provideB2CConfiguration(@ApplicationContext applicationContext: Context): B2CConfiguration {
        return B2CConfiguration(applicationContext)
    }
}
