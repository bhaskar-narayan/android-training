package com.bhaskar.bigoh.pagination.models

data class PhotoModel(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)