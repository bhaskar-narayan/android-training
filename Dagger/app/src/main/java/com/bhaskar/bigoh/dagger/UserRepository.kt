package com.bhaskar.bigoh.dagger

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor () {
    private val TAG = "UserRepository"
    fun saveUser(email: String, password: String) {
        Log.d(TAG, "User created")
    }
}