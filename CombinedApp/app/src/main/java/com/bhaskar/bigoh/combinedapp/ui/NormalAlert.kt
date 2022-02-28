package com.bhaskar.bigoh.combinedapp.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class NormalAlert: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("You have fired this Default Alert Dialog")
                .setPositiveButton("OK", null)
                .setNegativeButton("",
                    null)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}