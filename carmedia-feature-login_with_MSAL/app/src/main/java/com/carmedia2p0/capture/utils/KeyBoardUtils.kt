package com.carmedia2p0.capture.utils

import android.app.Activity
import android.content.Context
import android.os.IBinder
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import timber.log.Timber

object KeyBoardUtils {

    private const val TAG: String = "Keyboard_util"

    /**
     * This implementation hide keyboard from activity
     *
     * @param activity
     */
    fun hideKeyboard(activity: Activity) {
        try {
            val view = activity.window.currentFocus ?: return
            val inputManager = activity
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        } catch (e: Exception) {
            // Ignore exceptions if any
            Timber.tag(TAG).e(e, e.toString())
        }
    }

    /**
     * This imolementation close keyboard
     *
     * @param c
     * @param windowToken
     */
    fun closeKeyboard(c: Context, windowToken: IBinder?) {
        val mgr = c.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        mgr.hideSoftInputFromWindow(windowToken, 0)
    }

    /**
     * This imolementation is to setup Done keyboard
     *
     */
    fun setupKeyboardDone(context: Context, editText: EditText?, cursorVisible: Boolean = true) {
        editText!!.setOnEditorActionListener { v, actionId, event ->
            if (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER || actionId == EditorInfo.IME_ACTION_DONE) {
                val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
                editText.isCursorVisible = cursorVisible
            }
            false
        }
    }

    fun openKeyboardWhenFocus(context: Context, editable: EditText) {
        if (editable.requestFocus()) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editable, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}
