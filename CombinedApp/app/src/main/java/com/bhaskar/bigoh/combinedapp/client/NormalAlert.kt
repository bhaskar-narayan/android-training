package com.bhaskar.bigoh.combinedapp.client

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.bhaskar.bigoh.combinedapp.R

class NormalAlert : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(getString(R.string.default_alert_body))
                .setPositiveButton("OK", null)
                .setNegativeButton(
                    "",
                    null
                )
            builder.create()
        } ?: throw IllegalStateException(getString(R.string.activity_cannot_be_null))
    }
}