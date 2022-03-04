package com.bhaskar.bigoh.combinedapp.client

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.Layout
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.bhaskar.bigoh.combinedapp.R
import com.bhaskar.bigoh.combinedapp.databinding.CustomDialogLayoutBinding

class CustomAlert: DialogFragment() {
    private lateinit var binder: CustomDialogLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = DataBindingUtil.inflate(inflater, R.layout.custom_dialog_layout, container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binder.tapMe.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commitAllowingStateLoss()
        }
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.80).toInt()
        dialog!!.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
}