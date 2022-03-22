package com.bhaskar.bigoh.combinedapp.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.constants.Constant
import com.bhaskar.bigoh.combinedapp.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binder: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binder.createUserButton.setOnClickListener {
            val userEmailString = binder.userEmail.text.toString().trim()
            val passwordString = binder.password.text.toString().trim()
            val confirmPasswordString = binder.confirmPassword.text.toString().trim()

            if (confirmPasswordString != passwordString)
                return@setOnClickListener
            val sharedCredential = requireActivity().getSharedPreferences(
                Constant.SHARED_CREDENTIAL,
                Context.MODE_PRIVATE
            )
            val sharedEditor = sharedCredential.edit()
            sharedEditor.putString("userEmail", userEmailString)
            sharedEditor.putString("userPassword", passwordString)
            sharedEditor.apply()
            Toast.makeText(
                it.context,
                getString(R.string.registration_successful),
                Toast.LENGTH_SHORT
            ).show()
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, SharedPreferenceFragment()).commit()
        }
    }
}