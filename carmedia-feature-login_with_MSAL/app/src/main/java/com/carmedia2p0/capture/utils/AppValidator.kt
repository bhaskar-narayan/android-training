package com.carmedia2p0.capture.utils

import android.text.TextUtils
import android.util.Patterns

class AppValidator {

    companion object {
        fun isValidEmail(email: CharSequence?): Boolean {
            return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isValidEmail(email: String): Boolean? {
            val regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$"
            return email.matches(regex.toRegex())
        }

        var mobile: String = "^[0-9]{6,14}\$"

        fun isValidMobileNumber(phoneNumber: String): Boolean {
            return phoneNumber.matches(mobile.toRegex())
        }

        fun isValidName(name: String): Boolean {
            return name.matches("[a-zA-Z ]{3,}".toRegex())
        }

        fun isValidPassword(password: String): Boolean {
            return password.length in 5..50
        }

        fun isValidSalutations(salutations: String): Boolean {
            return salutations.length > 2
        }

        fun isValidAge(age: Int): Boolean {
            return age in 6..120
        }

        fun isValidOccupation(occupation: String): Boolean {
            return occupation.length > 3
        }

        fun isValidAddress(address: String): Boolean {
            return address.length > 10
        }

        fun isValidPinCode(pincode: String): Boolean {
            return pincode.length == 6
        }
    }
}
