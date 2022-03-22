package com.carmedia2p0.capture.ui.main.garage

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.databinding.GarageFragmentBinding
import com.carmedia2p0.capture.ui.base.fragment.BaseFragment
import com.carmedia2p0.capture.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GarageFragment : BaseFragment<GarageFragmentBinding, GarageViewModel>(R.layout.garage_fragment) {

    private val mViewModel: GarageViewModel by viewModels()
    private val activityViewModel: MainViewModel by activityViewModels()

    override fun onInitDataBinding(viewBinding: GarageFragmentBinding) {
    }

    override fun getViewModel(): GarageViewModel {
        return mViewModel
    }
}
