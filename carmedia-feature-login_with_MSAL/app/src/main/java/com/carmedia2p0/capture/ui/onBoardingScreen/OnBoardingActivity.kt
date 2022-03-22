package com.carmedia2p0.capture.ui.onBoardingScreen

import android.view.View
import androidx.activity.viewModels
import androidx.viewpager.widget.ViewPager
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.databinding.ActivityOnBoardingBinding
import com.carmedia2p0.capture.ui.base.activity.BaseActivity
import com.carmedia2p0.capture.ui.main.MainActivity
import com.carmedia2p0.capture.utils.addDots
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingActivity : BaseActivity<ActivityOnBoardingBinding, OnBoardingViewModel>(
    R.layout.activity_on_boarding
) {

    private val mViewModel: OnBoardingViewModel by viewModels()
    private var currentPage = 0

    override fun getBindingVariable(): Int {
        return 0
    }

    override fun onInitDataBinding(viewBinding: ActivityOnBoardingBinding) {
        initViews()
    }

    override fun getViewModel(): OnBoardingViewModel {
        return mViewModel
    }

    private fun initializeViewpager() {
        with(getViewDataBinding()) {
            viewPager.adapter = OnBoardingViewPager()
            addDots(currentPage, 5, llDotsIndicator)
            // tabLayoutIndicator.setupWithViewPager(viewPager, true)

            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    getStartedBtn.visibility = if (position == 4) View.VISIBLE else View.GONE
                    skipBtn.visibility = if (position == 4) View.GONE else View.VISIBLE
                    nextBtn.visibility = if (position == 4) View.GONE else View.VISIBLE

                    currentPage = position
                    addDots(currentPage, 5, llDotsIndicator)
                }

                override fun onPageScrollStateChanged(state: Int) {}
            })
        }
    }

    private fun navigateNextBtn() {
        with(getViewDataBinding()) {
            viewPager.currentItem = viewPager.currentItem.plus(1)
        }
    }

    private fun navigateToDashboard() {
        startActivity(MainActivity.makeIntent(this@OnBoardingActivity))
        finish()
    }

    private fun initViews() {
        with(getViewDataBinding()) {
            initializeViewpager()
            onItemClick = View.OnClickListener { view ->
                when (view.id) {
                    R.id.skipBtn -> navigateToDashboard()
                    R.id.nextBtn -> navigateNextBtn()
                    R.id.getStartedBtn -> navigateToDashboard()
                }
            }
        }
    }
}
