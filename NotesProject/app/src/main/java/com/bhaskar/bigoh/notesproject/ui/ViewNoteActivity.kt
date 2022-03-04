package com.bhaskar.bigoh.notesproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.bhaskar.bigoh.notesproject.R
import com.bhaskar.bigoh.notesproject.database.NoteDatabase
import com.bhaskar.bigoh.notesproject.database.NoteModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class ViewNoteActivity : AppCompatActivity() {
    private lateinit var titleViewText: EditText
    private lateinit var textViewText: EditText
    private var id by Delegates.notNull<Long>()
    private lateinit var database: NoteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_note)

        val title: String = intent.getStringExtra("title").toString()
        val text: String = intent.getStringExtra("text").toString()
        id = intent.getLongExtra("id", 0)

        titleViewText = findViewById(R.id.titleViewText)
        textViewText = findViewById(R.id.textViewText)
        val deleteButton: ImageButton = findViewById(R.id.deleteButton)
//        val fabEdit: FloatingActionButton = findViewById(R.id.fabEdit)
//        val fabSaveEdit: ExtendedFloatingActionButton = findViewById(R.id.fabSaveEdit)

        titleViewText.setText(title)
        textViewText.setText(text)

        database = NoteDatabase.getDatabase(this)

        deleteButton.setOnClickListener {
            database = NoteDatabase.getDatabase(this)
            GlobalScope.launch {
                database.noteDao().deleteNote(id)
            }
            Toast.makeText(this, "Note deleted", Toast.LENGTH_SHORT).show()
            this@ViewNoteActivity.finish()
        }

//        fabEdit.setOnClickListener {
//            val intent = Intent(this@ViewNoteActivity, EditNote::class.java)
//            intent.putExtra("id", id)
//            intent.putExtra("title", title)
//            intent.putExtra("text", text)
//            startActivity(intent)
//            this@ViewNoteActivity.finish()
//        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val title: String = titleViewText.text.toString().trim()
        val text: String = textViewText.text.toString().trim()

        if (title.isEmpty() && text.isEmpty()) {
            GlobalScope.launch {
                database.noteDao().deleteNote(id)
            }
            Toast.makeText(this@ViewNoteActivity, "Empty note deleted", Toast.LENGTH_SHORT).show()
            return
        }
        GlobalScope.launch {
            database.noteDao().updateNote(id, title, text)
        }
    }
}