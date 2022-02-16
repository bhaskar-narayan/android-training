package com.bhaskar.bigoh.servicelifecycle

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.*
import android.provider.Settings
import android.util.Log


class ServiceActivity : Service() {
    private lateinit var player : MediaPlayer
    private val TAG = "ServiceActivity"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val runnable = Runnable {
            run {
                player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
                player.isLooping = true
                player.start()
            }
        }
        val backgroundThread = Thread(runnable)
        backgroundThread.start()

        Log.d(TAG, "Main Thread::::  ${Thread.currentThread().id}")
        Log.d(TAG, "Background Thread::::  ${backgroundThread.id}")
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "onBind: ")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        player.stop()
    }

}