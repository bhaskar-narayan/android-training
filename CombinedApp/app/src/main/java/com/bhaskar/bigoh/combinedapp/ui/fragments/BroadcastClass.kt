package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.client.BroadcastClass
import com.bhaskar.bigoh.combinedapp.databinding.FragmentBroadCastBinding

class BroadcastClass : Fragment() {
    private lateinit var binder: FragmentBroadCastBinding
    private lateinit var receiver : BroadcastClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_broad_cast, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val localBroadcast: BroadcastReceiver = object: BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val message = intent.getStringExtra("passedValue")
                binder.clickText.text = message
            }

        }

        binder.clickText.setOnClickListener {
            LocalBroadcastManager.getInstance(it.context).registerReceiver(localBroadcast, IntentFilter("Local-Broadcast"))
            val intent = Intent("Local-Broadcast")
            intent.putExtra("passedValue", getString(R.string.clicked_button_using_local_brodcast))
            LocalBroadcastManager.getInstance(it.context).sendBroadcast(intent)
        }

        receiver = BroadcastClass()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            requireActivity().registerReceiver(receiver, it)
        }
    }

    override fun onStop() {
        super.onStop()
        requireActivity().unregisterReceiver(receiver)
    }
}