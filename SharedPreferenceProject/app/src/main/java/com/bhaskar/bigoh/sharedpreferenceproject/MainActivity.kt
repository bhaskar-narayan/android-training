package com.bhaskar.bigoh.sharedpreferenceproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    private val SHARED_CREDENTIAL = "bhaskar-credential"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEmail = findViewById<EditText>(R.id.userEmail)
        val userPassword = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val signupButton = findViewById<Button>(R.id.signupButton)

        signupButton.setOnClickListener {
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val sharedCredential = getSharedPreferences(SHARED_CREDENTIAL, Context.MODE_PRIVATE)
            val userEmailString = userEmail.text.toString().trim()
            val userPasswordString = userPassword.text.toString().trim()
            val fetchedEmail = sharedCredential.getString("userEmail", null)
            val fetchedPassword = sharedCredential.getString("userPassword", null)

            if ((userEmailString == fetchedEmail) && (userPasswordString == fetchedPassword))
                Toast.makeText(this@MainActivity, "Log in Successful!", Toast.LENGTH_LONG).show()
        }
    }
}