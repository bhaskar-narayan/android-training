package com.bhaskar.bigoh.dialogproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val defaultAlertButton = findViewById<Button>(R.id.defaultAlertButton)
        val customizedAlertButton = findViewById<Button>(R.id.customizedAlertButton)

        defaultAlertButton.setOnClickListener {
            val alertDialog = AlertDialogClass()
            alertDialog.show(supportFragmentManager, "default alert")
        }

        customizedAlertButton.setOnClickListener {
            val customAlertDialog = CustomAlertClass()
            customAlertDialog.show(supportFragmentManager, "custom alert")
        }
    }
}