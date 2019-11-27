package com.sample.starwarssample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.starwarssample.utils.SingleLiveData

abstract class BaseViewModel: ViewModel() {

    protected fun <T> createMutableLiveData(): LiveData<T> = MutableLiveData<T>()
    protected fun <T> createSingleLiveData(): LiveData<T> = SingleLiveData<T>()

    val errorState = createSingleLiveData<String>()

    protected fun <T> LiveData<T>.postValue(value: T?) {
        when (this) {
            is MutableLiveData<T> -> postValue(value)
            else -> throw Exception("Not using createMutableLiveData() or createSingleLiveData() to create live data")
        }
    }

    protected fun <T> LiveData<T>.setValue(value: T?) {
        when (this) {
            is MutableLiveData<T> -> setValue(value)
            else -> throw Exception("Not using createMutableLiveData() or createSingleLiveData() to create live data")
        }
    }
}