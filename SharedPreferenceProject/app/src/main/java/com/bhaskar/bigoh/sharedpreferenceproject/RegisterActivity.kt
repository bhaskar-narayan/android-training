package com.bhaskar.bigoh.sharedpreferenceproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    private val SHARED_CREDENTIAL = "bhaskar-credential"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val userEmail = findViewById<EditText>(R.id.userEmail)
        val password = findViewById<EditText>(R.id.password)
        val confirmPassword = findViewById<EditText>(R.id.confirmPassword)
        val createUserButton = findViewById<Button>(R.id.createUserButton)

        createUserButton.setOnClickListener {
            val userEmailString = userEmail.text.toString().trim()
            val passwordString = password.text.toString().trim()
            val confirmPasswordString = confirmPassword.text.toString().trim()

            if (confirmPasswordString != passwordString)
                return@setOnClickListener
            val sharedCredential = getSharedPreferences(SHARED_CREDENTIAL, Context.MODE_PRIVATE)
            val sharedEditor = sharedCredential.edit()
            sharedEditor.putString("userEmail", userEmailString)
            sharedEditor.putString("userPassword", passwordString)
            sharedEditor.apply()
            this@RegisterActivity.finish()
        }
    }
}