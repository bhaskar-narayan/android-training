package com.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mvvm.R
import com.mvvm.databinding.ActivityMainBinding
import com.mvvm.ui.fragments.NewsDownloadFragment
import com.mvvm.ui.fragments.NewsHomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        binding.mainBottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.homeMenu -> NewsHomeFragment().renderFragment()
                R.id.downloadMenu -> NewsDownloadFragment().renderFragment()
            }
            true
        }
    }

    private fun Fragment.renderFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.mainFragmentContainer, this)
        transaction.commit()
    }
}