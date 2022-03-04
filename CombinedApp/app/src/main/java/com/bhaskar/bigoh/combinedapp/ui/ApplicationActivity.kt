package com.bhaskar.bigoh.combinedapp.ui

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.bhaskar.bigoh.combinedapp.constants.Constant

class ApplicationActivity: Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Foreground"
            val descriptionText = "This is a sample description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(Constant.CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }
}