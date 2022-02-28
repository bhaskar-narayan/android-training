package com.bhaskar.bigoh.notesproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.bhaskar.bigoh.notesproject.R
import com.bhaskar.bigoh.notesproject.database.NoteDatabase
import com.bhaskar.bigoh.notesproject.database.NoteModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewNoteActivity : AppCompatActivity() {
    private lateinit var database: NoteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_note)

        val title: String = intent.getStringExtra("title").toString()
        val text: String = intent.getStringExtra("text").toString()
        val id: Long = intent.getLongExtra("id", 0)

        val titleViewText: TextView = findViewById(R.id.titleViewText)
        val textViewText: TextView = findViewById(R.id.textViewText)
        val deleteButton: ImageButton = findViewById(R.id.deleteButton)
        val fabEdit: FloatingActionButton = findViewById(R.id.fabEdit)

        titleViewText.text = title
        textViewText.text = text


        deleteButton.setOnClickListener {
            database = NoteDatabase.getDatabase(this)
            GlobalScope.launch {
                database.noteDao().deleteNote(id)
            }
            Toast.makeText(this, "Note deleted", Toast.LENGTH_SHORT).show()
            this@ViewNoteActivity.finish()
        }

        fabEdit.setOnClickListener {
            val intent = Intent(this@ViewNoteActivity, EditNote::class.java)
            intent.putExtra("id", id)
            intent.putExtra("title", title)
            intent.putExtra("text", text)
            startActivity(intent)
            this@ViewNoteActivity.finish()
        }
    }
}