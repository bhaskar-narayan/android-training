package com.bhaskar.bigoh.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstButton = findViewById<Button>(R.id.firstButton)
        var secondButton = findViewById<Button>(R.id.secondButton)

        firstButton.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            //fragmentTransaction.add(R.id.fragmentContainer, FirstFragment()).commit()
            fragmentTransaction.addToBackStack(null).add(R.id.fragmentContainer, FirstFragment()).commit()
        }
        secondButton.setOnClickListener{
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer, SecondFragment()).commit()
        }
    }
}