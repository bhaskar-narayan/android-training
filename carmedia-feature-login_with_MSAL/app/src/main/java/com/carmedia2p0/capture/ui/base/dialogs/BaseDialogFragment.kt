package com.carmedia2p0.capture.ui.base.dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.carmedia2p0.capture.BR
import com.carmedia2p0.capture.ui.base.activity.BaseActivity
import com.carmedia2p0.capture.ui.base.viewmodel.BaseViewModel

/**
 * Base Dialog fragment to standardize and simplify initialization for this component.
 *
 * @param layoutId Layout resource reference identifier.
 * @see DialogFragment
 */
abstract class BaseDialogFragment<B : ViewDataBinding, M : BaseViewModel>(
    @LayoutRes
    private val layoutId: Int,
) : DialogFragment() {

    private lateinit var viewBinding: B

    fun getViewBinding(): B = viewBinding

    /**
     * Called to Initialize view data binding variables when fragment view is created.
     */
    abstract fun onInitDataBinding(viewBinding: B)

    abstract fun getViewModel(): M

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewBinding.setVariable(BR.viewModel, getViewModel())
        viewBinding.lifecycleOwner = viewLifecycleOwner
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        onInitDataBinding(viewBinding)
    }

    private fun initObservers() {
        getViewModel().errorLiveData.observe(
            viewLifecycleOwner,
            { error ->
                getBaseActivity().showSnackbar(error.peekContent())
            }
        )

        getViewModel().messageLiveData.observe(
            viewLifecycleOwner,
            { message ->
                getBaseActivity().showSnackbar(message.peekContent())
            }
        )

        getViewModel().loadingLiveData.observe(
            viewLifecycleOwner,
            { visible ->
                getBaseActivity().showProgress(visible.peekContent())
            }
        )
    }

    fun showMessage(message: String) {
        getBaseActivity().showToast(message)
    }

    fun onError(appError: String) {
        getViewModel().onError(appError)
    }

    private fun showProgress(visible: Boolean) {
        getBaseActivity().showProgress(visible)
    }

    fun hideProgressBar() {
        getBaseActivity().hideProgressBar()
    }

    fun showToast(message: String?) {
        getBaseActivity().showToast(message)
    }

    private fun getBaseActivity() = requireActivity() as BaseActivity<*, *>
}
