package com.bhaskar.bigoh.allservicelifecycle

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class BackgroundActivity : Service() {
    private lateinit var player : MediaPlayer
    private val TAG = "BackgroundActivity"
    override fun onCreate() {
        super.onCreate()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val runnable = Runnable {
            run {
                player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
                player.isLooping = true
                player.start()
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
        player.stop()
        Log.d(TAG, "onDestroy: ")
    }
}