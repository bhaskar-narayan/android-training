package com.carmedia2p0.capture.utils.livedata

class EventObject(key: Int, vararg value: Any) {
    var key: Int? = null
    var value: Array<Any>
    init {
        this.key = key
        this.value = value as Array<Any>
    }
}
