package com.bhaskar.bigoh.twowaydatabinding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bhaskar.bigoh.twowaydatabinding.R
import com.bhaskar.bigoh.twowaydatabinding.databinding.ActivityMainBinding
import com.bhaskar.bigoh.twowaydatabinding.viewmodel.DataViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var dataViewModel : DataViewModel
    private lateinit var binder : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataViewModel = DataViewModel()

        binder = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binder.lifecycleOwner = this@MainActivity

        binder.viewModel = dataViewModel
    }
}