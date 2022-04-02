package com.bhaskar.bigoh.viewpagerproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager : ViewPager2 = findViewById(R.id.viewPager)
        val circleIndicator : CircleIndicator3 = findViewById(R.id.circleIndicator)

        val dataObject = DataClass()
        dataObject.getValues()

//        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//        viewPager.clipToPadding = false
//        viewPager.clipChildren = false
//        viewPager.offscreenPageLimit = 3
//        viewPager.getChildAt(0).overScrollMode = View.OVER_SCROLL_NEVER
        viewPager.clipToPadding = false
        viewPager.setPageTransformer(MarginPageTransformer(30))
        viewPager.setPadding(48, 8, 48, 8)
        viewPager.offscreenPageLimit = 3

        viewPager.adapter = ViewPagerAdapter(dataObject.allTitle, dataObject.allDescription, dataObject.allImages)
//        val transformer = CompositePageTransformer()
//        transformer.addTransformer(MarginPageTransformer(40))
//        transformer.addTransformer { page, position ->
//            val r = 1 - abs(position)
//            page.scaleY = 0.85f + r * 0.15f
//        }
//        viewPager.setPageTransformer(transformer)
        circleIndicator.setViewPager(viewPager)
    }
}