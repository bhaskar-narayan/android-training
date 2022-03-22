package com.carmedia2p0.capture.ui.onBoardingScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.carmedia2p0.capture.R

class OnBoardingViewPager : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = container.context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View =
            layoutInflater.inflate(R.layout.item_onboarding, container, false)
        container.addView(view)

//        val welcomeImage = view.findViewById<ImageView>(R.id.slide_image)
        val welcomeHeading = view.findViewById<TextView>(R.id.heading)

        when (position) {
            0 -> {
//                welcomeImage.setImageResource(R.drawable.on_boarding_first)
                welcomeHeading.setText(R.string.view_inventory)
            }

            1 -> {
//                welcomeImage.setImageResource(R.drawable.on_boarding_second)
                welcomeHeading.setText(R.string.view_tasks)
            }

            2 -> {
//                welcomeImage.setImageResource(R.drawable.on_boarding_third)
                welcomeHeading.setText(R.string.start_capturing)
            }
            3 -> {
//                welcomeImage.setImageResource(R.drawable.on_boarding_third)
                welcomeHeading.setText(R.string.complete_and_upload)
            }
            4 -> {
//                welcomeImage.setImageResource(R.drawable.on_boarding_third)
                welcomeHeading.setText(R.string.view_overall_performance)
            }
        }
        return view
    }

    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}
