package com.sample.starwarssample.ui.dialog

import android.content.Context
import android.widget.Button
import androidx.annotation.StringRes
import com.sample.starwarssample.R
import kotlinx.android.synthetic.main.dialog_error.view.*

class ErrorDialog(context: Context, @StringRes textRes: Int) : BaseDialogHelper(context) {

    override val layoutId = R.layout.dialog_error

    private val cancelButton: Button by lazy {
        dialogView.cancelButton
    }

    private val okButton: Button by lazy {
        dialogView.okButton
    }

    init {
        dialogView.errorTextView.text = context.getText(textRes)
    }

    fun setOnCancelListener(func: (() -> Unit)) =
        with(cancelButton) {
            setClickListenerToDialogIcon(func)
        }

    fun setOnOkListener(func: (() -> Unit)) =
        with(okButton) {
            setClickListenerToDialogIcon(func)
        }
}