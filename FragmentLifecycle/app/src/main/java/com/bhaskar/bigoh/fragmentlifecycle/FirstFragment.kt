package com.bhaskar.bigoh.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FirstFragment : Fragment() {
    private val TAG = "LifeCycle"
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: First")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: First")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: First")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: First")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(TAG, "onViewStateRestored: First")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: First")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: First")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: First")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: First")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: First")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: First")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: First")
    }

}