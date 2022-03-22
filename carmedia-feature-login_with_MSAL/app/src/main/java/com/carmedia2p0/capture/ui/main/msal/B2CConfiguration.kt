package com.carmedia2p0.capture.ui.main.msal

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.carmedia2p0.capture.R
import com.microsoft.identity.client.*
import com.microsoft.identity.client.exception.MsalException
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@SuppressLint("LogNotTimber")
class B2CConfiguration @Inject constructor(private val context: Context) {

    var b2cApp: ISingleAccountPublicClientApplication? = null
    private val TAG = B2CConfiguration::class.java.simpleName
    var mActiveAccount: IAccount ? = null

    /**
     * The value in this class has to map with the json configuration file (auth_config_b2c.json).
     * i.e. If you are using the following json file.
     * {
     *   "client_id" : "90c0fe63-bcf2-44d5-8fb7-b8bbc0b29dc6",
     *   "redirect_uri" : "msauth://com.azuresamples.msalandroidapp/1wIqXSqBj7w%2Bh11ZifsnqwgyKrY%3D",
     *   "account_mode" : "MULTIPLE",
     *   "broker_redirect_uri_registered": false,
     *   "authorities": [
     *     {
     *       "type": "B2C",
     *       "authority_url": "https://fabrikamb2c.b2clogin.com/tfp/fabrikamb2c.onmicrosoft.com/b2c_1_susi/",
     *       "default": true
     *     },
     *     {
     *       "type": "B2C",
     *       "authority_url": "https://fabrikamb2c.b2clogin.com/tfp/fabrikamb2c.onmicrosoft.com/b2c_1_edit_profile/"
     *     },
     *     {
     *       "type": "B2C",
     *       "authority_url": "https://fabrikamb2c.b2clogin.com/tfp/fabrikamb2c.onmicrosoft.com/b2c_1_reset/"
     *     }
     *   ]
     * }
     * <p>
     * This file contains 2 B2C policies, namely "b2c_1_susi", "b2c_1_edit_profile" and "b2c_1_reset"
     * Its azureAdB2CHostName is "fabrikamb2c.b2clogin.com"
     * Its tenantName is "fabrikamb2c.onmicrosoft.com"
     */

    /**
     * Name of the policies/user flows in your B2C tenant.
     * See https://docs.microsoft.com/en-us/azure/active-directory-b2c/active-directory-b2c-reference-policies for more info.
     */

    fun getPolicies(): List<String> {
        return listOf(context.getString(R.string.policies))
    }

    /**
     * Name of your B2C tenant.
     */
    private val tenantName = context.getString(R.string.tenantName)

    private val azureAdB2CHostName = context.getString(R.string.azureAdB2CHostName)

    /**
     * Returns an authority for the given policy name.
     *
     * @param policyName name of a B2C policy.
     */
    fun getAuthorityFromPolicyName(policyName: String): String {
        return "https://$azureAdB2CHostName/tfp/$tenantName/$policyName/"
    }

    /**
     * Returns an array of scopes you wish to acquire as part of the returned token result.
     * These scopes must be added in your B2C application page.
     */
    fun getScopes(): List<String> {
        return listOf(context.getString(R.string.scope))
    }

    fun initSingleAccountPublicClientApplication() {
        PublicClientApplication.createSingleAccountPublicClientApplication(
            context,
            R.raw.auth_config_account,
            object : IPublicClientApplication.ISingleAccountApplicationCreatedListener {
                override fun onCreated(application: ISingleAccountPublicClientApplication) {
                    b2cApp = application
                    Log.d(TAG, "onCreated B2C app created")
                    loadAccount()
                }

                @SuppressLint("LogNotTimber")
                override fun onError(exception: MsalException) {
                    Log.d(TAG, "onError: $exception ")
                    Toast.makeText(context, exception.toString(), Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    fun loadAccount() {
        if (b2cApp == null) {
            return
        }
        b2cApp!!.getCurrentAccountAsync(object :
                ISingleAccountPublicClientApplication.CurrentAccountCallback {
                override fun onAccountLoaded(activeAccount: IAccount?) {
                    Log.d(TAG, "onAccountLoaded: ")
                    activeAccount?.let {
                        mActiveAccount = it
                    }
                }
                override fun onAccountChanged(priorAccount: IAccount?, currentAccount: IAccount?) {
                    if (currentAccount == null) {
                        Log.d(TAG, "onAccountChanged: ")
                        Toast.makeText(context, "onAccountChanged: ", Toast.LENGTH_LONG).show()
//                      performOperationOnSignOut()
                    }
                }
                override fun onError(exception: MsalException) {
                    Log.d(TAG, "onError: ")
                    Toast.makeText(context, exception.toString(), Toast.LENGTH_LONG).show()
                }
            })
    }

    fun acquireToken(callback: AuthenticationCallback, activity: Activity) {
        b2cApp?.let {
            val parameters = AcquireTokenParameters.Builder()
                .startAuthorizationFromActivity(activity)
                .fromAuthority(
                    getAuthorityFromPolicyName(
                        getPolicies()[0]
                    )
                )
                .withScopes(getScopes())
                .withPrompt(Prompt.WHEN_REQUIRED)
                .withCallback(callback)
                .build()
            b2cApp!!.acquireToken(parameters)
        } ?: Toast.makeText(context, "Wrong b2cApp Configuration ", Toast.LENGTH_LONG).show()
    }

    fun onLogoutAsync() {
        b2cApp?.let {
            mActiveAccount?.let {
                b2cApp!!.signOut(object : ISingleAccountPublicClientApplication.SignOutCallback {
                    override fun onSignOut() {
                    }

                    override fun onError(exception: MsalException) {
                    }
                })
            }
        }
    }

    suspend fun acquireTokenSilentAsync(): IAuthenticationResult? {
        b2cApp?.let {
            mActiveAccount?.let {
                return suspendCoroutine {
                    val parameters = AcquireTokenSilentParameters.Builder()
                        .fromAuthority(
                            getAuthorityFromPolicyName(
                                getPolicies()[0]
                            )
                        )
                        .withScopes(getScopes())
                        .forAccount(mActiveAccount)
                        .withCallback(object : SilentAuthenticationCallback {
                            override fun onSuccess(authenticationResult: IAuthenticationResult?) {
                                Log.d(TAG, " b2CConfiguration onSuccess: ")
                                authenticationResult?.let {
                                    mActiveAccount = authenticationResult.account
                                }
                                it.resume(authenticationResult)
                            }

                            override fun onError(exception: MsalException?) {
                                Log.d(TAG, "b2CConfiguration onError: ")
                                it.resumeWithException(Exception(exception?.cause))
                            }
                        })
                        .build()
                    b2cApp!!.acquireTokenSilentAsync(parameters)
                }
            } ?: throw Exception("No mActiveAccount")
        } ?: throw Exception("Wrong b2cApp Configuration")
    }
}
