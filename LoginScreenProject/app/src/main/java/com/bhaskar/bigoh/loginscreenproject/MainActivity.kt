package com.bhaskar.bigoh.loginscreenproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val showPasswordImage = findViewById<ImageView>(R.id.showPasswordImage)
        val hidePasswordImage = findViewById<ImageView>(R.id.hidePasswordImage)

        hidePasswordImage.setOnClickListener {
            if (passwordEditText.inputType == 1)
                return@setOnClickListener
            passwordEditText.inputType = 1
            hidePasswordImage.visibility = View.INVISIBLE
            showPasswordImage.visibility = View.VISIBLE
        }

        showPasswordImage.setOnClickListener {
            if (passwordEditText.inputType == 129)
                return@setOnClickListener
            passwordEditText.inputType = 129
            showPasswordImage.visibility = View.INVISIBLE
            hidePasswordImage.visibility = View.VISIBLE
        }
    }
}
