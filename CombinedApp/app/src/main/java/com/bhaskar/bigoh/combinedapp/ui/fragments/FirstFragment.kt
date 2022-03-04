package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.databinding.ActivityMainBinding
import com.bhaskar.bigoh.combinedapp.databinding.FragmentFirstBinding
import com.bhaskar.bigoh.combinedapp.ui.MainActivity

class FirstFragment : Fragment() {
    private lateinit var binder: FragmentFirstBinding
    companion object {
        val TAG = "FirstFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: ")
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        binder.firstFragmentText.setOnClickListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, SecondFragment()).commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")

    }
}