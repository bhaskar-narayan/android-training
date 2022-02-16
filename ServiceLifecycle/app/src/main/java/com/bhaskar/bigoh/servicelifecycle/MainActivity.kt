package com.bhaskar.bigoh.servicelifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val stopButton = findViewById<Button>(R.id.stopButton)
        val serviceIntent = Intent(this@MainActivity, ServiceActivity::class.java)

        startButton.setOnClickListener {
            startService(serviceIntent)
        }

        stopButton.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}