package com.carmedia2p0.capture

import android.annotation.SuppressLint
import android.app.Application
import com.carmedia2p0.capture.data.AppPreferences
import com.carmedia2p0.capture.ui.main.msal.B2CConfiguration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class CarMediaApplication : Application() {
    private var mInstance: CarMediaApplication? = null

    @Inject lateinit var b2CConfiguration: B2CConfiguration

    companion object {
        private var mInstance: CarMediaApplication? = null

        fun getInstance(): CarMediaApplication? {
            if (mInstance == null) {
                mInstance =
                    CarMediaApplication()
            }
            return mInstance
        }
    }

    @SuppressLint("MissingPermission")
    override fun onCreate() {
        super.onCreate()
        mInstance = this
        initPreferences()
        b2CConfiguration.initSingleAccountPublicClientApplication()
    }

    private fun initPreferences() {
        AppPreferences.init(this)
    }
}
