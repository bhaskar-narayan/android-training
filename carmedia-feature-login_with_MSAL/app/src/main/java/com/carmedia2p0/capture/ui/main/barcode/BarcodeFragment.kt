package com.carmedia2p0.capture.ui.main.barcode

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.databinding.BarcodeFragmentBinding
import com.carmedia2p0.capture.ui.base.fragment.BaseFragment
import com.carmedia2p0.capture.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BarcodeFragment : BaseFragment<BarcodeFragmentBinding, BarcodeViewModel>(R.layout.barcode_fragment) {

    private val mViewModel: BarcodeViewModel by viewModels()
    private val activityViewModel: MainViewModel by activityViewModels()

    override fun onInitDataBinding(viewBinding: BarcodeFragmentBinding) {
    }

    override fun getViewModel(): BarcodeViewModel {
        return mViewModel
    }
}
