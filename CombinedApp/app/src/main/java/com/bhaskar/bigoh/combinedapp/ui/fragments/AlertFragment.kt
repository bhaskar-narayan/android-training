package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.client.CustomAlert
import com.bhaskar.bigoh.combinedapp.client.NormalAlert
import com.bhaskar.bigoh.combinedapp.databinding.FragmentAlertBinding

class AlertFragment : Fragment() {
    private lateinit var binder: FragmentAlertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_alert, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.normalAlert.setOnClickListener {
            val alertDialog = NormalAlert()
            alertDialog.show(childFragmentManager, "default-alert")
        }

        binder.customAlert.setOnClickListener {
            val customAlertDialog = CustomAlert()
            customAlertDialog.show(childFragmentManager, "custom alert")
        }
    }
}