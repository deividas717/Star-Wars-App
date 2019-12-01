package com.sample.starwarssample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.sample.starwarssample.ui.dialog.DataLoadingDialog
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    abstract val layoutId: Int
    private var dataLoadingDialog: AlertDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutId, container, false)

    protected fun <T> LiveData<T>.observe(action: (T) -> Unit) {
        observe(viewLifecycleOwner, Observer { data -> data?.let(action) })
    }

    protected fun handleDataLoadingDialog(showDialog: Boolean) {
        if (showDialog) {
            dataLoadingDialog = DataLoadingDialog(requireContext()).create()
            dataLoadingDialog?.show()
        } else {
            dataLoadingDialog?.hide()
        }
    }

    protected fun showErrorDialog(textId: String) {

    }
}