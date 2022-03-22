package com.carmedia2p0.capture.ui.barcode

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.carmedia2p0.capture.R
import com.carmedia2p0.capture.databinding.ActivityBarcodeBinding
import com.carmedia2p0.capture.ui.base.activity.BaseActivity
import com.google.zxing.Result
import dagger.hilt.android.AndroidEntryPoint
import me.dm7.barcodescanner.zxing.ZXingScannerView
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

@AndroidEntryPoint
class BarcodeActivity :
    BaseActivity<ActivityBarcodeBinding, BarcodeViewModel>(
        R.layout.activity_barcode
    ),
    ZXingScannerView.ResultHandler,
    EasyPermissions.PermissionCallbacks {

    private val mViewModel: BarcodeViewModel by viewModels()
    private var mScannerView: ZXingScannerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mScannerView = ZXingScannerView(this)
        setContentView(mScannerView)
    }

    override fun getBindingVariable(): Int {
        return 0
    }

    override fun getViewModel(): BarcodeViewModel {
        return mViewModel
    }

    override fun handleResult(p0: Result?) {
        Toast.makeText(this, p0?.text ?: "fail", Toast.LENGTH_SHORT).show()
        mScannerView!!.resumeCameraPreview(this)
    }

    public override fun onResume() {
        super.onResume()
        mScannerView!!.setResultHandler(this)
        methodRequiresTwoPermission()
//        mScannerView!!.startCamera()
    }

    public override fun onPause() {
        super.onPause()
        mScannerView!!.stopCamera()
    }

    override fun onInitDataBinding(viewBinding: ActivityBarcodeBinding) {
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        mScannerView?.let {
            it.startCamera()
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            // Do something after user returned from app settings screen, like showing a Toast.
            Toast.makeText(
                this,
                "Return from setting",
                Toast.LENGTH_SHORT
            ).show()
            methodRequiresTwoPermission()
        }
    }

    private fun methodRequiresTwoPermission() {
        val perms = arrayOf(Manifest.permission.CAMERA, Manifest.permission.INTERNET)
        if (EasyPermissions.hasPermissions(this, *perms)) {
            mScannerView?.let {
                it.startCamera()
            }
        } else {
            EasyPermissions.requestPermissions(
                this, "Please give camera permission to detect barcodes",
                0, *perms
            )
        }
    }
}
