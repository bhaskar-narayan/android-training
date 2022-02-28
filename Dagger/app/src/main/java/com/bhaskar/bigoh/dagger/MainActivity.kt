package com.bhaskar.bigoh.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhaskar.bigoh.dagger.component.DaggerRegistrationInterface

class MainActivity : AppCompatActivity() {
    private lateinit var userRepository: UserRepository
    private lateinit var emailService: EmailService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerRegistrationInterface.builder().build()

        val userRegistration = component.getUserRegistrationService()

        userRegistration.registerUser("Bhaskar", "123456")
    }
}