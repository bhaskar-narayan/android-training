package com.carmedia2p0.capture.ui.virtual360View

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.WindowManager
import android.webkit.*
import androidx.activity.viewModels
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.databinding.ActivityVirtual360ViewBinding
import com.carmedia2p0.capture.ui.base.activity.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Virtual360ViewActivity : BaseActivity<ActivityVirtual360ViewBinding, Virtual360ViewModel>(
    R.layout.activity_virtual360_view
) {

    private val mViewModel: Virtual360ViewModel by viewModels()
    override fun getBindingVariable(): Int {
        return 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
    }
    @SuppressLint("SetJavaScriptEnabled")
    override fun onInitDataBinding(viewBinding: ActivityVirtual360ViewBinding) {
        val webSettings: WebSettings = viewBinding.mWebView.getSettings()
        showProgress(true)
        webSettings.domStorageEnabled = true
        webSettings.javaScriptEnabled = true
        viewBinding.mWebView.loadUrl("https://app.lapentor.com/sphere/carmedia")
        viewBinding.mWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                view.loadUrl(request.url.toString())
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                showProgress(false)
                super.onPageFinished(view, url)
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                showProgress(false)
//                showSnackbar( "Error ${error?.description.toString()}")
            }

            override fun onReceivedHttpError(
                view: WebView?,
                request: WebResourceRequest?,
                errorResponse: WebResourceResponse?
            ) {
                showProgress(false)
                showSnackbar("Error ${errorResponse?.statusCode}")
            }
        }
    }

    override fun getViewModel(): Virtual360ViewModel {
        return mViewModel
    }
}
