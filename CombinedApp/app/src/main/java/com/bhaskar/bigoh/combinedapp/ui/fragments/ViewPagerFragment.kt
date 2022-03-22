package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.adapters.ViewPagerAdapter
import com.bhaskar.bigoh.combinedapp.databinding.FragmentViewPagerBinding
import com.bhaskar.bigoh.combinedapp.models.ViewPagerData

class ViewPagerFragment : Fragment() {
    private lateinit var binder: FragmentViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val dataObject = ViewPagerData(view)
        dataObject.getValues()

        binder.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binder.viewPager.adapter =
            ViewPagerAdapter(dataObject.allTitle, dataObject.allDescription, dataObject.allImages)
        binder.circleIndicator.setViewPager(binder.viewPager)


    }
}