package com.carmedia2p0.capture.ui.main.home

import androidx.fragment.app.viewModels
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.databinding.HomeFragmentBinding
import com.carmedia2p0.capture.ui.base.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>(R.layout.home_fragment) {

    private val mViewModel: HomeViewModel by viewModels()
    private val TAG = HomeFragment::class.java.simpleName

    override fun onInitDataBinding(viewBinding: HomeFragmentBinding) {
        with(viewBinding) {
        }
    }
    override fun getViewModel(): HomeViewModel {
        return mViewModel
    }
}
