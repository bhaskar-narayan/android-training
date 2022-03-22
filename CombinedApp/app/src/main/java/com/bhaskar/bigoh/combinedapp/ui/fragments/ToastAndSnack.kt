package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.databinding.FragmentToastAndSnackBinding
import com.google.android.material.snackbar.Snackbar

class ToastAndSnack : Fragment() {
    private lateinit var binder: FragmentToastAndSnackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder =
            DataBindingUtil.inflate(inflater, R.layout.fragment_toast_and_snack, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.toastButton.setOnClickListener {
            Toast.makeText(it.context, getString(R.string.fired_toast), Toast.LENGTH_SHORT).show()
        }

        binder.snackButton.setOnClickListener {
            Snackbar.make(it, getString(R.string.fired_snack), Snackbar.LENGTH_SHORT).show()
        }
    }
}