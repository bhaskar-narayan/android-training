package com.bhaskar.bigoh.broadcastproject

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BroadcastReceiverClass : BroadcastReceiver() {
    private val TAG = "BroadCast Log"
    override fun onReceive(context: Context?, intent: Intent?) {
        val isModeActive = intent?.getBooleanExtra("state", false) ?: return
        if (isModeActive)
            Toast.makeText(context, "Flight Mode Active", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Flight Mode Inactive", Toast.LENGTH_SHORT).show()
    }
}