package com.bhaskar.bigoh.combinedapp.ui

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.databinding.ActivityMainBinding
import com.bhaskar.bigoh.combinedapp.ui.fragments.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "MainActivity"
    }

    private lateinit var binder: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Log.d(TAG, "onCreate: ")

        toggle =
            ActionBarDrawerToggle(this, binder.drawerLayout, R.string.nav_open, R.string.nav_close)
        renderFragment(ActivityFragment())

        binder.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        binder.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.activityLifeCycle -> renderFragment(ActivityFragment())
                R.id.fragmentLifeCycle -> renderFragment(FirstFragment())
                R.id.news -> renderFragment(RoomRetrofitFragment())
                R.id.alert -> renderFragment(AlertFragment())
                R.id.viewPager -> renderFragment(ViewPagerFragment())
                R.id.toast -> renderFragment(ToastAndSnack())
                R.id.login -> renderFragment(LoginScreen())
                R.id.mvvm -> renderFragment(DataBinding())
                R.id.broadCast -> renderFragment(BroadcastReceiverClass())
                R.id.service -> renderFragment(AllService())
                R.id.shared -> renderFragment(SharedPreferenceFragment())
            }
            true
        }
    }

    private fun renderFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, fragment)
        transaction.commit()
        binder.drawerLayout.closeDrawers()
    }

    private fun renderNewsFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }
}
