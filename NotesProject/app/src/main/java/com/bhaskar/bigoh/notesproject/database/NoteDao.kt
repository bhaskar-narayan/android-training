package com.bhaskar.bigoh.notesproject.database

import android.icu.text.CaseMap
import android.os.FileObserver.DELETE
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(noteModel: NoteModel)

    @Query ("SELECT * FROM notes_table")
    fun getAllNotes() : LiveData<List<NoteModel>>

    @Query ("DELETE FROM notes_table WHERE id = :id")
    fun deleteNote(id: Long)

    @Query ("UPDATE notes_table SET title = :title, text = :text WHERE id = :id")
    fun updateNote(id: Long, title: String, text: String)
}