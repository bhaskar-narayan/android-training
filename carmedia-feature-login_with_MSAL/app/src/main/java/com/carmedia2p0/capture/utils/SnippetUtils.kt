package com.carmedia2p0.capture.utils

import android.content.Context
import android.widget.Toast
import com.google.gson.Gson

class SnippetUtils {
    companion object {

        fun <T> fromJson(json: String?, classOfT: Class<T>): T? {
            if (json == null)
                return null
            return Gson().fromJson(json, classOfT)
        }

        fun String.toast(context: Context) = Toast.makeText(context, this, Toast.LENGTH_LONG).show()
    }
}
