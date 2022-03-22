@file:Suppress("Annotator")

package com.carmedia2p0.capture.data

import kotlin.collections.ArrayList

object DataManager {

    var cookies: ArrayList<String> = arrayListOf()

    fun clear() {
        cookies = java.util.ArrayList()
    }
}
