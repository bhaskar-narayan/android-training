package com.bhaskar.bigoh.combinedapp.models

import android.view.View
import com.bhaskar.bigoh.combinedapp.R

class ViewPagerData(view: View) {
    var view: View = view
    var allTitle = mutableListOf<String>()
    var allDescription = mutableListOf<String>()
    var allImages = mutableListOf<Int>()

    fun getValues() {
        allTitle.add(view.context.getString(R.string.swift))
        allTitle.add(view.context.getString(R.string.security_assured))
        allTitle.add(view.context.getString(R.string.vaccinated_stuff))

        allDescription.add(view.context.getString(R.string.lorem))
        allDescription.add(view.context.getString(R.string.lorem))
        allDescription.add(view.context.getString(R.string.lorem))

        allImages.add(R.drawable.clock)
        allImages.add(R.drawable.secure)
        allImages.add(R.drawable.vaccine)
    }
}