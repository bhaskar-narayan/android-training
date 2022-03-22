package com.carmedia2p0.capture.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.data.AppPreferences
import com.carmedia2p0.capture.databinding.ActivityLoginBinding
import com.carmedia2p0.capture.ui.base.activity.BaseActivity
import com.carmedia2p0.capture.ui.main.MainActivity
import com.carmedia2p0.capture.ui.main.msal.B2CConfiguration
import com.carmedia2p0.capture.ui.onBoardingScreen.OnBoardingActivity
import com.microsoft.identity.client.AuthenticationCallback
import com.microsoft.identity.client.IAuthenticationResult
import com.microsoft.identity.client.exception.MsalClientException
import com.microsoft.identity.client.exception.MsalException
import com.microsoft.identity.client.exception.MsalServiceException
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@SuppressLint("LogNotTimber")
@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(
    R.layout.activity_login
) {
    private val TAG = LoginActivity::class.java.simpleName
    private val mViewModel: LoginViewModel by viewModels()
    @Inject
    lateinit var b2CConfiguration: B2CConfiguration

    override fun getBindingVariable(): Int {
        return 0
    }

    override fun onInitDataBinding(viewBinding: ActivityLoginBinding) {
        with(getViewDataBinding()) {
            onItemClick = View.OnClickListener { view ->
                when (view.id) {
                    R.id.loginBtn -> {
                        b2CConfiguration.acquireToken(getAuthInteractiveCallback(), this@LoginActivity)
                    }
                }
            }
        }
    }

    private fun getAuthInteractiveCallback(): AuthenticationCallback {
        return object : AuthenticationCallback {
            override fun onSuccess(authenticationResult: IAuthenticationResult) {
                /* Successfully got a token, use it to call a protected resource */
                val accessToken = authenticationResult.accessToken
                Log.d(TAG, "onSuccess:$accessToken ")
                Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_LONG).show()
                AppPreferences.onLogin(authenticationResult)
                b2CConfiguration.mActiveAccount = authenticationResult.account
                if (authenticationResult.account.claims?.get("CarMedia2p0.IsFirstLogin") as Boolean) navigateToOnBoarding() else navigateToHome()
            }

            override fun onError(exception: MsalException?) {
                if (exception is MsalClientException) {
                    Toast.makeText(this@LoginActivity, exception.toString(), Toast.LENGTH_LONG).show()
                } else if (exception is MsalServiceException) {
                    Toast.makeText(this@LoginActivity, exception.toString(), Toast.LENGTH_LONG).show()
                }
            }
            override fun onCancel() {
                /* User canceled the authentication */
            }
        }
    }

    override fun getViewModel(): LoginViewModel {
        return mViewModel
    }

    private fun navigateToOnBoarding() {
        val intent = Intent(this, OnBoardingActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
