package com.carmedia2p0.capture.model.response.getInventory

data class Item(
    val condition: String,
    val dateCreated: String,
    val dealerId: String,
    val id: String,
    val make: String,
    val mediaStatus: String,
    val model: String,
    val profileImage: ProfileImage,
    val stockNumber: String,
    val trim: String,
    val vin: String,
    val year: String
)
