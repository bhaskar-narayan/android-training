package com.carmedia2p0.capture.data

import android.content.Context
import android.content.SharedPreferences
import com.carmedia2p0.capture.model.customModel.userInfo.UserAccountInfo
import com.carmedia2p0.capture.utils.constant.PrefConstant.ACCOUNT_INFO
import com.carmedia2p0.capture.utils.constant.PrefConstant.IS_LOGIN
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.microsoft.identity.client.IAuthenticationResult

object AppPreferences {

    private const val NAME = "PREF_SHARED_PREFS_NAME"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val ACCOUNT_INFO_CACHED = Pair(ACCOUNT_INFO, "")
    private val IS_LOGIN_CACHED = Pair(IS_LOGIN, false)

    fun init(context: Context) {
        preferences = context.getSharedPreferences(
            NAME,
            MODE
        )
    }

/**
     * SharedPreferences extension function, so we won't need to call edit() and apply()
     * ourselves on every SharedPreferences operation.
     */
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    private var userAccountInfo: String?
        get() = preferences.getString(ACCOUNT_INFO_CACHED.first, ACCOUNT_INFO_CACHED.second)
        set(value) = preferences.edit {
            it.putString(ACCOUNT_INFO_CACHED.first, value)
            it.apply()
        }

    var isLogin: Boolean
        get() = preferences.getBoolean(IS_LOGIN_CACHED.first, IS_LOGIN_CACHED.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_LOGIN_CACHED.first, value)
        }

    fun getCachedUserAccountInfo(): UserAccountInfo? {
        val cachedJson: String = userAccountInfo!!
        val gson = Gson()
        return if (cachedJson == "") {
            null
        } else gson.fromJson(
            cachedJson,
            object : TypeToken<UserAccountInfo>() {}.type
        )
    }

    fun setCachedUserAccountInfo(userAccountInfo: UserAccountInfo) {
        val gson = Gson()
        this.userAccountInfo = gson.toJson(userAccountInfo)
    }

    fun onLogout() {
        userAccountInfo = ""
        isLogin = false
    }

    fun onLogin(authenticationResult: IAuthenticationResult) {
        val userAccountInfo = UserAccountInfo(accessToken = authenticationResult.accessToken)
        setCachedUserAccountInfo(userAccountInfo)
        isLogin = true
    }
}
