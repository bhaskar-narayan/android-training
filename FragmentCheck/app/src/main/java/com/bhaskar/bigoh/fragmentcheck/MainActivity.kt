package com.bhaskar.bigoh.fragmentcheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityD"
    private var flag = true
    private lateinit var transaction: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")

        val button: Button = findViewById(R.id.button)

        transaction = supportFragmentManager

        button.setOnClickListener {
            flag = if (flag) {
                FirstFragment().renderFragment()
                false
            } else {
                SecondFragment().renderFragment()
                true
            }
        }
    }
    private fun Fragment.renderFragment() {
        transaction.beginTransaction().add(R.id.container, this).addToBackStack(null).commit()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("backStack", "${transaction.backStackEntryCount}")
        if (transaction.backStackEntryCount == 0)
            this@MainActivity.finish()
    }
}