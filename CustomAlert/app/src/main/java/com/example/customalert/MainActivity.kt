    package com.example.customalert

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

    class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.custom_alert_layout, null)
            val dialog = Dialog(this)
            dialog.setContentView(dialogBinding)
            dialog.setCancelable(true)
            //dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            val dismissButton: Button = dialogBinding.findViewById(R.id.dismissButton)
            dismissButton.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}