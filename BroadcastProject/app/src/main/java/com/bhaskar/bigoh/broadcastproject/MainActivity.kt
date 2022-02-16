package com.bhaskar.bigoh.broadcastproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {
    private lateinit var receiver : BroadcastReceiverClass
    private lateinit var clickTest : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickTest = findViewById<TextView>(R.id.clickText)

        clickTest.setOnClickListener {
            LocalBroadcastManager.getInstance(this).registerReceiver(localBroadcastReceiver, IntentFilter("Local-Broadcast"))
            var intent = Intent("Local-Broadcast")
            intent.putExtra("passedValue", "Clicked Button using Local Broadcast")
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }

        receiver = BroadcastReceiverClass()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
    private val localBroadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            // Get extra data included in the Intent
            val message = intent.getStringExtra("passedValue")
            clickTest.text = message
        }
    }
}