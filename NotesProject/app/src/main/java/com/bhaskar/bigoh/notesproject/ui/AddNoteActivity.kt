package com.bhaskar.bigoh.notesproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.bhaskar.bigoh.notesproject.R
import com.bhaskar.bigoh.notesproject.database.NoteDatabase
import com.bhaskar.bigoh.notesproject.database.NoteModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddNoteActivity : AppCompatActivity() {
    private val TAG = "ADDNOTEDEBUG"
    private lateinit var database : NoteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val titleEditText : EditText = findViewById(R.id.titleEditText)
        val textEditText : EditText = findViewById(R.id.textEditText)
        val fabSave : ExtendedFloatingActionButton = findViewById(R.id.fabSave)

        database = NoteDatabase.getDatabase(this)

        fabSave.setOnClickListener {
            val title : String = titleEditText.text.toString()
            val text : String = textEditText.text.toString()
            if (title.isEmpty() && text.isEmpty()) {
                Toast.makeText(this, "Missing field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            GlobalScope.launch {
                database.noteDao().insertNote(NoteModel(0, title, text))
            }
            Toast.makeText(this@AddNoteActivity, "Note saved", Toast.LENGTH_SHORT).show()
            this@AddNoteActivity.finish()
        }
    }
}