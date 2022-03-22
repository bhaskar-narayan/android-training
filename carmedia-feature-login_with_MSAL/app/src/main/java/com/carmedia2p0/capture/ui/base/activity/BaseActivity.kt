@file:Suppress("DEPRECATION")

package com.carmedia2p0.capture.ui.base.activity

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.carmedia2p0.capture.BR
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.ui.base.viewmodel.BaseViewModel
import com.carmedia2p0.capture.utils.KeyBoardUtils.hideKeyboard
import com.google.android.material.snackbar.Snackbar

/**
 * Base Activity to standardize and simplify initialization for this component.
 *
 * @param layoutId Layout resource reference identifier.
 * @see AppCompatActivity
 */
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel>(
    @LayoutRes private val layoutId: Int,
) : AppCompatActivity() {

    private lateinit var mViewDataBinding: T
    private var progressDialog: ProgressDialog? = null

    abstract fun getBindingVariable(): Int

//    protected var mHandler = Handler()

    /**
     * Called to Initialize view data binding variables when fragment view is created.
     */
    abstract fun onInitDataBinding(viewBinding: T)

    abstract fun getViewModel(): V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        mViewDataBinding.setVariable(BR.viewModel, getViewModel())
        mViewDataBinding.lifecycleOwner = this
        initObservers()
        onInitDataBinding(mViewDataBinding)
    }

    fun getViewDataBinding(): T {
        return mViewDataBinding
    }

    fun showSnackbar(message: String) {
        hideProgressBar()
        hideKeyboard(this)
        Snackbar.make(
            getViewDataBinding().root,
            message,
            Snackbar.LENGTH_SHORT
        )
            .show()
    }

    private fun initObservers() {
        getViewModel().errorLiveData.observe(
            this,
            { error ->
                showSnackbar(error.peekContent())
            }
        )

        getViewModel().messageLiveData.observe(
            this,
            { message ->
                showSnackbar(message.peekContent())
            }
        )

        getViewModel().loadingLiveData.observe(
            this,
            { visible ->
                showProgress(visible.peekContent())
            }
        )
    }

    fun showProgress(visible: Boolean) {
        if (visible) {
            hideKeyboard(this)
            hideProgressBar()
            progressDialog = showLoadingDialog(this)
        } else {
            hideProgressBar()
        }
    }

    fun hideProgressBar() {
        progressDialog?.cancel()
    }

    private fun showLoadingDialog(context: Context?): ProgressDialog? {
        val progressDialog = ProgressDialog(context)
        progressDialog.show()
        if (progressDialog.window != null) {
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            progressDialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }

        progressDialog.setContentView(R.layout.progress_view)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        return progressDialog
    }

    fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
