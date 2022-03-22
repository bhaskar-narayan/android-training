package com.carmedia2p0.capture.data.network

import android.annotation.SuppressLint
import android.util.Log
import com.carmedia2p0.capture.data.AppPreferences
import com.carmedia2p0.capture.ui.main.msal.B2CConfiguration
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BasicAuthInterceptor(private val b2CConfiguration: B2CConfiguration) : Interceptor {

    private val TAG = "BasicAuthInterceptor"
    @SuppressLint("LogNotTimber")
    override fun intercept(chain: Interceptor.Chain): Response {

        synchronized(this) {
            val originalRequest = chain.request()
            AppPreferences.getCachedUserAccountInfo() ?: return chain.proceed(originalRequest)
            val newRequest: Request = originalRequest.newBuilder()
                .addHeader("Authorization", "Bearer ${AppPreferences.getCachedUserAccountInfo()!!.accessToken}")
                .build()
            val initialResponse = chain.proceed(newRequest)
            try {
                when (initialResponse.code) {
                    200 -> {
                        Log.d(TAG, "GET: 200")
                        return initialResponse
                    }
                    403, 401 -> {
                        Log.d(TAG, "GET: 403")
                        Log.d(TAG, "THREAD--->: ${Thread.currentThread().name}")
                        val authenticationResult = runBlocking {
                            b2CConfiguration.acquireTokenSilentAsync()
                        }

                        Log.d(TAG, "THREAD AFTER GET authenticationResult--->: ${Thread.currentThread().name}")
                        AppPreferences.onLogin(authenticationResult!!)
                        initialResponse.close()
                        return chain.call().clone().execute()
                    }
                    else -> {
                        Log.d(TAG, "THREAD--->: ${Thread.currentThread().name}")
                        return initialResponse
                    }
                }
            } catch (e: Exception) {
                return initialResponse
            }
        }
    }
}
