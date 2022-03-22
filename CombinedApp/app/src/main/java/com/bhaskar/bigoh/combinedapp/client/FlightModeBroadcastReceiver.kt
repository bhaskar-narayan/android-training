package com.bhaskar.bigoh.combinedapp.client

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.bhaskar.bigoh.combinedapp.R

class FlightModeBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val isModeActive = intent?.getBooleanExtra("state", false) ?: return
        if (isModeActive)
            Toast.makeText(
                context,
                context.getString(R.string.flight_mode_active),
                Toast.LENGTH_SHORT
            ).show()
        else
            Toast.makeText(
                context,
                context.getString(R.string.flight_mode_inactive),
                Toast.LENGTH_SHORT
            ).show()
    }
}