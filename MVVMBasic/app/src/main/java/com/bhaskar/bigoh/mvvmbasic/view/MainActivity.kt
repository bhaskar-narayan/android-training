package com.bhaskar.bigoh.mvvmbasic.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bhaskar.bigoh.mvvmbasic.R
import com.bhaskar.bigoh.mvvmbasic.databinding.ActivityMainBinding
import com.bhaskar.bigoh.mvvmbasic.viewmodel.ViewModelClass

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : ViewModelClass
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.lifecycleOwner = this@MainActivity
        viewModel = ViewModelClass()
        binding.viewModel = viewModel
    }
}