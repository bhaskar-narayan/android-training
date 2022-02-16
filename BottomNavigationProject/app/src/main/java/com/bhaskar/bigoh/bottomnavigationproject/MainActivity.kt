package com.bhaskar.bigoh.bottomnavigationproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bhaskar.bigoh.bottomnavigationproject.fragments.DashboardFragment
import com.bhaskar.bigoh.bottomnavigationproject.fragments.DeviceFragment
import com.bhaskar.bigoh.bottomnavigationproject.fragments.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private val dashboardFragment = DashboardFragment()
    private val settingFragment = SettingFragment()
    private val deviceFragment = DeviceFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_dashboard -> renderFragment(dashboardFragment)
                R.id.ic_settings -> renderFragment(settingFragment)
                R.id.ic_devices -> renderFragment(deviceFragment)
            }
            true
        }
    }
    private fun renderFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutContainer, fragment)
        transaction.commit()
    }
}