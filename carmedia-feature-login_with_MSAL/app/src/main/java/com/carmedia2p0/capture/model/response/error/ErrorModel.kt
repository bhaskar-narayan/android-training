package com.carmedia2p0.capture.model.response.error

data class ErrorModel(
    val detail: String,
    val status: String,
    val title: String,
    val type: String
)
