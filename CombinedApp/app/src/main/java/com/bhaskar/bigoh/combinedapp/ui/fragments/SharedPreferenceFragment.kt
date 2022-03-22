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
import com.bhaskar.bigoh.combinedapp.databinding.FragmentSharedPreferenceBinding

class SharedPreferenceFragment : Fragment() {
    private lateinit var binding: FragmentSharedPreferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shared_preference, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signupButton.setOnClickListener {
            val fragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, RegisterFragment()).commit()
        }

        binding.loginButton.setOnClickListener {
            val sharedCredential = requireActivity().getSharedPreferences(
                Constant.SHARED_CREDENTIAL,
                Context.MODE_PRIVATE
            )
            val userEmailString = binding.userEmail.text.toString().trim()
            val userPasswordString = binding.password.text.toString().trim()
            val fetchedEmail = sharedCredential.getString("userEmail", null)
            val fetchedPassword = sharedCredential.getString("userPassword", null)

            if ((userEmailString == fetchedEmail) && (userPasswordString == fetchedPassword))
                Toast.makeText(it.context, getString(R.string.login_successful), Toast.LENGTH_LONG)
                    .show()
            else
                Toast.makeText(it.context, getString(R.string.login_failed), Toast.LENGTH_SHORT)
                    .show()
        }
    }
}