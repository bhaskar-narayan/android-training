package com.carmedia2p0.capture.di

import android.content.Context
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.data.network.BasicAuthInterceptor
import com.carmedia2p0.capture.data.network.CookiesInterceptor
import com.carmedia2p0.capture.ui.main.msal.B2CConfiguration
import com.carmedia2p0.capture.utils.constant.ApiConstant.OK_HTTP_CLIENT_TIME_OUT
import com.carmedia2p0.capture.utils.retrofit.FlowCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HttpModule {

    @CarMediaApi
    @Singleton
    @Provides
    fun providesBaseUrl(@ApplicationContext context: Context): String {
        return context.getString(R.string.server_ip)
    }

    @CarMediaApi
    @Singleton
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @CarMediaApi
    @Provides
    fun providesCookiesInterceptor(): CookiesInterceptor {
        return CookiesInterceptor()
    }

    @CarMediaApi
    @Singleton
    @Provides
    fun provideBasicAuthInterceptor(b2CConfiguration: B2CConfiguration) = BasicAuthInterceptor(b2CConfiguration)

    @CarMediaApi
    @Singleton
    @Provides
    fun provideOkHttpClient(@CarMediaApi loggingInterceptor: HttpLoggingInterceptor, @CarMediaApi basicAuthInterceptor: BasicAuthInterceptor, cookiesInterceptor: CookiesInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.callTimeout(OK_HTTP_CLIENT_TIME_OUT, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(OK_HTTP_CLIENT_TIME_OUT, TimeUnit.SECONDS)
        okHttpClient.readTimeout(OK_HTTP_CLIENT_TIME_OUT, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(OK_HTTP_CLIENT_TIME_OUT, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(loggingInterceptor)
        okHttpClient.addInterceptor(basicAuthInterceptor)
        okHttpClient.build()
        return okHttpClient.build()
    }

    @CarMediaApi
    @Singleton
    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @CarMediaApi
    @Singleton
    @Provides
    fun provideRetrofitClient(@CarMediaApi okHttpClient: OkHttpClient, @CarMediaApi baseUrl: String, @CarMediaApi converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addCallAdapterFactory(FlowCallAdapterFactory.create())
            .build()
    }
}
