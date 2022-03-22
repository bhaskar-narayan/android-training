package com.carmedia2p0.capture.data.network

import com.carmedia2p0.capture.data.DataManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CookiesInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())

        if (chain.request().url.toString()
            .contains("account/login") && originalResponse.headers("Set-Cookie").isNotEmpty()
        ) {
            getResponseCookies(originalResponse)
        }

        return originalResponse
    }

    private fun getResponseCookies(raw: Response?) {
        DataManager.cookies.addAll(raw!!.headers.values("Set-Cookie"))
        if (raw.priorResponse != null) {
            getResponseCookies(raw.priorResponse)
        }
    }
}
