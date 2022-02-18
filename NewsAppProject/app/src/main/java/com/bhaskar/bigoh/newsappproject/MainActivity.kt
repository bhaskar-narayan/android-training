package com.bhaskar.bigoh.newsappproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bhaskar.bigoh.newsappproject.fragments.DownloadScreen
import com.bhaskar.bigoh.newsappproject.fragments.HomeScreen
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val TAG = "Check"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottom_navigation)

        renderFragment(HomeScreen())

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> renderFragment(HomeScreen())
                R.id.downloaded -> renderFragment(DownloadScreen())
            }
            true
        }
    }


    private fun renderFragment (fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContainer, fragment)
        transaction.commit()
    }
}