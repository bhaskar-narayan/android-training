package com.bhaskar.bigoh.pushnotificationproject

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : AppCompatActivity() {
    private val NOTIFICATION_CHANNEL_ID = "1"
    private val NOTIFICATION_CHANNEL_NAME = "Test Channel"
    private val NOTIFICATION_CHANNEL_DESCRIPTION = "Test Channel"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationButton = findViewById<Button>(R.id.notificationButton)

        createNotificationChannel()

        notificationButton.setOnClickListener {
            val builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_fb_icon)
                .setContentTitle("Hey! Notification")
                .setContentText("This is a sample notification made by Bhaskar Narayan")
                .setStyle(NotificationCompat.BigTextStyle()
                    .bigText("This is a longer line of this notification where setStyle "))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            with(NotificationManagerCompat.from(this)) {
                notify(1, builder.build())
            }
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = NOTIFICATION_CHANNEL_NAME
            val description = NOTIFICATION_CHANNEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance)
            channel.description = description
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }
}