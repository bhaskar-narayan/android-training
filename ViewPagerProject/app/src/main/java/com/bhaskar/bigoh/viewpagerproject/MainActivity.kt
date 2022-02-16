package com.bhaskar.bigoh.viewpagerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager : ViewPager2 = findViewById(R.id.viewPager)
        val circleIndicator : CircleIndicator3 = findViewById(R.id.circleIndicator)

        val dataObject = DataClass()
        dataObject.getValues()

        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.adapter = ViewPagerAdapter(dataObject.allTitle, dataObject.allDescription, dataObject.allImages)
        circleIndicator.setViewPager(viewPager)
    }
}