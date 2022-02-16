package com.bhaskar.bigoh.toastandsnackbarproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toastButton = findViewById<Button>(R.id.toastButton)
        val snackButton = findViewById<Button>(R.id.snackButton)

        toastButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "You have fired this Toast message", Toast.LENGTH_LONG).show()
        }

        snackButton.setOnClickListener {
            Snackbar.make(it, "You have fired this Snackbar", Snackbar.LENGTH_LONG).show()
        }
    }
}