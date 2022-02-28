package com.bhaskar.bigoh.notesproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhaskar.bigoh.notesproject.R
import com.bhaskar.bigoh.notesproject.adapter.HomeAdapter
import com.bhaskar.bigoh.notesproject.database.NoteDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var database: NoteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab : FloatingActionButton = findViewById(R.id.fab)

        fetchAllNotes()

        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchAllNotes() {
        database = NoteDatabase.getDatabase(this)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        val adapter = HomeAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        database.noteDao().getAllNotes().observe(this, Observer {
            adapter.setData(it, database)
        })
    }
}