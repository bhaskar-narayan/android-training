package com.bhaskar.bigoh.dagger

import javax.inject.Inject

class UserRegistration @Inject constructor (private val userRepository: UserRepository, private val emailService: EmailService) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "xyz@gmail.com", "Hey Buddy!")
    }
}