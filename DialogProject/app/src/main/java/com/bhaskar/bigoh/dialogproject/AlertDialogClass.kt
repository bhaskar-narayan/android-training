package com.bhaskar.bigoh.dialogproject

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class AlertDialogClass : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("You have fired this Alert Dialog")
                .setPositiveButton("OK", null)

                .setNegativeButton("",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}