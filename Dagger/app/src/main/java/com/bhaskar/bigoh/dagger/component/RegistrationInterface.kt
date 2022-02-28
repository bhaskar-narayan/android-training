package com.bhaskar.bigoh.dagger.component

import com.bhaskar.bigoh.dagger.UserRegistration
import dagger.Component

@Component
interface RegistrationInterface {
    fun getUserRegistrationService (): UserRegistration
}