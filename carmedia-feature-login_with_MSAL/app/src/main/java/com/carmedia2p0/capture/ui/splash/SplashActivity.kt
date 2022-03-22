package com.carmedia2p0.capture.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.activity.viewModels
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.data.AppPreferences
import com.carmedia2p0.capture.databinding.ActivitySplashBinding
import com.carmedia2p0.capture.ui.base.activity.BaseActivity
import com.carmedia2p0.capture.ui.login.LoginActivity
import com.carmedia2p0.capture.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(
    R.layout.activity_splash
) {
    private var mDelayHandler: Handler? = null

    private val SPLASH_DELAY: Long = 3000 // 3 seconds

    private val mViewModel: SplashViewModel by viewModels()

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            validateUserSession()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)

        mDelayHandler = Handler()

        // Navigate with delay
        mDelayHandler?.postDelayed(mRunnable, SPLASH_DELAY)
    }

    override fun getBindingVariable(): Int {
        return 0
    }

    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler?.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }

    override fun onInitDataBinding(viewBinding: ActivitySplashBinding) {
        initViews()
    }

    private fun initViews() {
    }

    override fun getViewModel(): SplashViewModel {
        return mViewModel
    }

    private fun validateUserSession() {
        if (AppPreferences.isLogin)navigateToHome() else navigateToLogin()
    }

    private fun navigateToHome() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToLogin() {
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
