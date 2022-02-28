package com.bhaskar.bigoh.combinedapp.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.bhaskar.bigoh.combinedapp.R

class CustomAlert: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            builder.setView(inflater.inflate(R.layout.custom_dialog_layout, null))
                .setPositiveButton("OK",
                    null)
                .setNegativeButton("",
                    null)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}