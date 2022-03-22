package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.databinding.FragmentDataBindingBinding
import com.bhaskar.bigoh.combinedapp.viewmodels.DataBindingViewModel

class DataBinding : Fragment() {
    private lateinit var dataBindingViewModel: DataBindingViewModel
    private lateinit var binder: FragmentDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBindingViewModel = DataBindingViewModel()
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_data_binding, container, false)
        binder.viewModel = dataBindingViewModel
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}