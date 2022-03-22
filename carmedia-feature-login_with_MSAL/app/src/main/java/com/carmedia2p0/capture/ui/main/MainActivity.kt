package com.carmedia2p0.capture.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.databinding.ActivityMainBinding
import com.carmedia2p0.capture.ui.base.activity.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.navigation.NavigationBarItemView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {

    private val mViewModel: MainViewModel by viewModels()

    companion object {
        fun makeIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun getBindingVariable(): Int {
        return 0
    }

    override fun onInitDataBinding(viewBinding: ActivityMainBinding) {
        initViews()
    }

    @SuppressLint("RestrictedApi")
    private fun initViews() {
        with(getViewDataBinding()) {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.dashboardNavHostFragment) as NavHostFragment
            val navController: NavController = navHostFragment.navController
            NavigationUI.setupWithNavController(bottomNavigationView, navController)

            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.homeFragment -> {
                    }

                    R.id.inventoryFragment -> {
                    }

                    R.id.garageFragment -> {
                    }

                    R.id.barcodeFragment -> {
                    }
                }
            }
            val menuView: BottomNavigationMenuView = bottomNavigationView.getChildAt(0) as BottomNavigationMenuView
            for (i in 0 until menuView.childCount) {
                if (i == 3) {
                    val displayMetrics: DisplayMetrics = resources.displayMetrics
                    (menuView.getChildAt(i) as NavigationBarItemView).setIconSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 41f, displayMetrics).toInt())
                }
            }
        }
    }

    override fun getViewModel(): MainViewModel {
        return mViewModel
    }
}
