package com.sample.starwarssample.ui.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog

abstract class BaseDialogHelper(context: Context) {

    abstract val layoutId: Int
    private var dialog: AlertDialog? = null
    open var cancelable: Boolean = false

    protected val dialogView: View by lazy {
        LayoutInflater.from(context).inflate(layoutId, null)
    }

    open fun create(): AlertDialog {
        dialog = builder
            .setCancelable(cancelable)
            .setView(dialogView)
            .create()

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog!!
    }

    private val builder: AlertDialog.Builder by lazy {
        AlertDialog.Builder(context).setView(dialogView)
    }

    protected fun View.setClickListenerToDialogIcon(func: (() -> Unit)) =
        setOnClickListener {
            func.invoke()
            dialog?.dismiss()
        }
}