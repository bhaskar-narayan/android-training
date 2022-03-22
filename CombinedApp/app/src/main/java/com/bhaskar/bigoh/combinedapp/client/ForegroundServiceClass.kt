package com.bhaskar.bigoh.combinedapp.client

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.ui.fragments.AllService

class ForegroundServiceClass : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val resultIntent = Intent(this@ForegroundServiceClass, AllService::class.java)
        val pendingIntent =
            PendingIntent.getActivity(this@ForegroundServiceClass, 0, resultIntent, 0)

        val notificationBuilder =
            NotificationCompat.Builder(this, "Foreground Service").setContentIntent(pendingIntent)
                .setSmallIcon(
                    R.drawable.ic_android
                ).setContentTitle("Foreground Service")
                .setContentText(getString(R.string.notification_body))
        val notification = notificationBuilder.build()
        val runnable = Runnable {
            run {
                startForeground(1, notification)
            }
        }
        val thread = Thread(runnable)
        thread.start()
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        stopForeground(true)
        stopSelf()
    }
}