package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.client.BackgroundServiceClass
import com.bhaskar.bigoh.combinedapp.client.ForegroundServiceClass
import com.bhaskar.bigoh.combinedapp.databinding.FragmentAllServiceBinding
import com.bhaskar.bigoh.combinedapp.databinding.FragmentDataBindingBinding
import com.bhaskar.bigoh.combinedapp.viewmodels.DataBindingViewModel

class AllService : Fragment() {
    private lateinit var binder: FragmentAllServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_all_service, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val backgroundServiceIntent = Intent(view.context, BackgroundServiceClass::class.java)
        val foregroundServiceIntent = Intent(view.context, ForegroundServiceClass::class.java)


        binder.startBackgroundButton.setOnClickListener {
            requireActivity().startService(backgroundServiceIntent)
            binder.startBackgroundButton.isEnabled = false
            Toast.makeText(this@AllService.context, getString(R.string.ringtone_is_ringing), Toast.LENGTH_SHORT).show()
        }
        binder.stopBackgroundButton.setOnClickListener {
            requireActivity().stopService(backgroundServiceIntent)
            binder.startBackgroundButton.isEnabled = true
            Toast.makeText(this@AllService.context, getString(R.string.ringtone_stopped), Toast.LENGTH_SHORT).show()
        }


        binder.startForegroundButton.setOnClickListener {
            requireActivity().startForegroundService(foregroundServiceIntent)
            binder.startForegroundButton.isEnabled = false
            Toast.makeText(this@AllService.context, getString(R.string.notification_fired), Toast.LENGTH_SHORT).show()
        }
        binder.stopForegroundButton.setOnClickListener {
            requireActivity().stopService(foregroundServiceIntent)
            binder.startForegroundButton.isEnabled = true
            Toast.makeText(this@AllService.context, getString(R.string.notification_removed), Toast.LENGTH_SHORT).show()
        }
    }
}