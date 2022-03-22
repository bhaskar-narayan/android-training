package com.bhaskar.bigoh.combinedapp.client

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings


class BackgroundServiceClass : Service() {
    private lateinit var player: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val runnable = Runnable {
            run {
                player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
                player.isLooping = true
                player.start()
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
        player.stop()
    }
}