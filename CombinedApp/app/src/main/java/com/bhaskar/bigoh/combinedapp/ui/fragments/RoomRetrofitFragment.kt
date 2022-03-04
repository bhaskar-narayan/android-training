package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.database.NewsDatabase
import com.bhaskar.bigoh.combinedapp.databinding.FragmentNewsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class RoomRetrofitFragment : Fragment() {
    private lateinit var binder: FragmentNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        renderFragment(NewsViewFragment())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> renderFragment(NewsViewFragment())
                R.id.download -> renderFragment(NewsDownloadFragment())
            }
            true
        }
    }
    private fun renderFragment (fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.commit()
    }
}
