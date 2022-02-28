package com.bhaskar.bigoh.notesproject.ui

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bhaskar.bigoh.notesproject.R
import com.bhaskar.bigoh.notesproject.database.NoteDatabase
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditNote : AppCompatActivity() {
    private lateinit var database : NoteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val titleEditText : EditText = findViewById(R.id.titleEditText)
        val textEditText : EditText = findViewById(R.id.textEditText)
        val fabSave : ExtendedFloatingActionButton = findViewById(R.id.fabSave)

        val id: Long = intent.getLongExtra("id", 0)
        val title: String = intent.getStringExtra("title").toString()
        val text: String = intent.getStringExtra("text").toString()

        titleEditText.setText(title)
        textEditText.setText(text)


        database = NoteDatabase.getDatabase(this)

        fabSave.setOnClickListener {
            val title : String = titleEditText.text.toString()
            val text : String = textEditText.text.toString()
            if (title.isEmpty() && text.isEmpty()) {
                Toast.makeText(this, "Missing field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            GlobalScope.launch {
                database.noteDao().updateNote(id, title, text)
            }
            Toast.makeText(this@EditNote, "Note edited", Toast.LENGTH_SHORT).show()
            this@EditNote.finish()
        }
    }
}