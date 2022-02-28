package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.ui.CustomAlert
import com.bhaskar.bigoh.combinedapp.ui.NormalAlert

class AlertFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_alert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val normalAlert: Button = view.findViewById(R.id.normalAlert)
        val customAlert: Button = view.findViewById(R.id.customAlert)

        normalAlert.setOnClickListener {
            val alertDialog = NormalAlert()
            alertDialog.show(childFragmentManager, "default-alert")
        }

        customAlert.setOnClickListener {
            val customAlertDialog = CustomAlert()
            customAlertDialog.show(childFragmentManager, "custom alert")
        }
    }
}