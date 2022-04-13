package com.bhaskar.experimental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.progressindicator.LinearProgressIndicator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val indicator: CircularProgressIndicator = findViewById(R.id.indicator)
        indicator.progress = 340
    }
}