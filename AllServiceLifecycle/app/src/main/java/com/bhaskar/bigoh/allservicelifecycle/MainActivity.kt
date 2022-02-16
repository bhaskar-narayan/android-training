package com.bhaskar.bigoh.allservicelifecycle

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stopBackgroundButton = findViewById<Button>(R.id.stopBackgroundButton)
        val startBackgroundButton = findViewById<Button>(R.id.startBackgroundButton)

        val startForegroundButton = findViewById<Button>(R.id.startForegroundButton)
        val stopForegroundButton = findViewById<Button>(R.id.stopForegroundService)

        val backgroundServiceIntent = Intent(this, BackgroundActivity::class.java)
        val foregroundServiceIntent = Intent(this, ForegroundActivity::class.java)

        startBackgroundButton.setOnClickListener {
            startService(backgroundServiceIntent)
        }

        stopBackgroundButton.setOnClickListener {
            stopService(backgroundServiceIntent)
        }

        startForegroundButton.setOnClickListener {
            startForegroundService(foregroundServiceIntent)
        }
        stopForegroundButton.setOnClickListener {
            stopService(foregroundServiceIntent)
        }
    }
}