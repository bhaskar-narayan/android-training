package com.bhaskar.bigoh.roomproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "contact_table")
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name : String,
    val phone : String,
    val date : Date
    )