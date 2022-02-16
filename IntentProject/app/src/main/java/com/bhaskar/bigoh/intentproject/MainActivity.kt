package com.bhaskar.bigoh.intentproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)
        val userMessage = findViewById<EditText>(R.id.userMessage)
        val expIntent = findViewById<Button>(R.id.exIntent)
        val impIntent = findViewById<Button>(R.id.impIntent)

        expIntent.setOnClickListener {
            val userNameString = userName.text.toString()
            val passwordString = password.text.toString()
            val explicitIntent = Intent(this@MainActivity, ExplicitActivity::class.java)
            explicitIntent.putExtra("userName", userNameString)
            explicitIntent.putExtra( "password", passwordString)
            startActivity(explicitIntent)
        }

        impIntent.setOnClickListener {
            val userMessageString = userMessage.text.toString()
            val implicitIntent : Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, userMessageString)
                type = "text/plain"
            }
            val fireIntent = Intent.createChooser(implicitIntent, "Implicit Intent Text Sharing")
            startActivity(fireIntent)
        }
    }
}