package com.bhaskar.bigoh.notesproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NoteModel (
        @PrimaryKey(autoGenerate = true)
        var id : Long,
        var title : String,
        var text : String
        )