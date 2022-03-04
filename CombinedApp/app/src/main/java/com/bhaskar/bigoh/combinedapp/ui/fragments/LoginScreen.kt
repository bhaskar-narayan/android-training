package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.databinding.FragmentLoginScreenBinding

class LoginScreen : Fragment() {
    private lateinit var binder: FragmentLoginScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_login_screen, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.hidePasswordImage.setOnClickListener {
            if (binder.passwordEditText.inputType == 1)
                return@setOnClickListener
            binder.passwordEditText.inputType = 1
            binder.hidePasswordImage.visibility = View.INVISIBLE
            binder.showPasswordImage.visibility = View.VISIBLE
        }

        binder.showPasswordImage.setOnClickListener {
            if (binder.passwordEditText.inputType == 129)
                return@setOnClickListener
            binder.passwordEditText.inputType = 129
            binder.showPasswordImage.visibility = View.INVISIBLE
            binder.hidePasswordImage.visibility = View.VISIBLE
        }
    }
}