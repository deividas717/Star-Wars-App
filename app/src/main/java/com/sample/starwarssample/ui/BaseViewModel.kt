package com.sample.starwarssample.ui

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.starwarssample.utils.SingleLiveData

abstract class BaseViewModel : ViewModel() {

    private fun <T> createSingleLiveData(): LiveData<T> = SingleLiveData<T>()
    protected fun <T> createMutableLiveData(): LiveData<T> = MutableLiveData<T>()

    internal val loadingState = createSingleLiveData<Boolean>()
    internal val errorState = createSingleLiveData<@StringRes Int>()

    protected fun <T> LiveData<T>.setValue(value: T?) {
        when (this) {
            is MutableLiveData<T> -> setValue(value)
            else -> throw Exception("Not using createMutableLiveData() or createSingleLiveData() to create live data")
        }
    }
}