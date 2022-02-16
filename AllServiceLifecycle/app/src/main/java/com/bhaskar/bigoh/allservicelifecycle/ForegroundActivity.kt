package com.bhaskar.bigoh.allservicelifecycle

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class ForegroundActivity : Service() {
    private val TAG = "ForegroundActivity"
    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val resultIntent = Intent(this@ForegroundActivity, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this@ForegroundActivity, 0, resultIntent, 0)

        val notificationBuilder = NotificationCompat.Builder(this, "Foreground Service").setContentIntent(pendingIntent).setSmallIcon(R.mipmap.ic_launcher)
        val notification = notificationBuilder.build()
        val runnable = Runnable {
            run {
                startForeground(1, notification)
                Log.d(TAG, "onStartCommand: ")
            }
        }
        val thread = Thread(runnable)
        thread.start()
        return START_STICKY
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        stopForeground(true)
        stopSelf()
    }
}