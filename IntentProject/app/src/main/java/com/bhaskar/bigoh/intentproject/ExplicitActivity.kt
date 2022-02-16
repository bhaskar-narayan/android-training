package com.bhaskar.bigoh.intentproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)

        val userName = intent.getStringExtra("userName").toString()
        val password = intent.getStringExtra("password").toString()
        val userNameText = findViewById<TextView>(R.id.userName)
        val passwordText = findViewById<TextView>(R.id.password)

        userNameText.text = userName
        passwordText.text = password

        Toast.makeText(this@ExplicitActivity, "Explicit intent fired", Toast.LENGTH_LONG).show()
    }
}