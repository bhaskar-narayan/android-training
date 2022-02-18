package com.bhaskar.bigoh.roomproject

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bhaskar.bigoh.roomproject.data.Contact
import com.bhaskar.bigoh.roomproject.data.ContactDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var database : ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickText : TextView = findViewById(R.id.clickText)

        database = ContactDatabase.getDatabase(this@MainActivity)

        GlobalScope.launch {
            database.
            contactDao().
            insertContact(Contact(0, "Bhaskar Narayan", "7596949008", Date()))
        }

        clickText.setOnClickListener {
            database.contactDao().getContact().observe(this, Observer {
                Log.d("contactDB", it[0].name.toString())
            })
        }
    }
}