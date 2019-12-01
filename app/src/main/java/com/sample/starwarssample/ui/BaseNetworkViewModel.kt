package com.sample.starwarssample.ui

import androidx.lifecycle.viewModelScope
import com.sample.starwarssample.R
import com.sample.starwarssample.utils.NetworkUtils
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseNetworkViewModel(private val networkUtils: NetworkUtils) : BaseViewModel() {

    protected fun performNetworkRequest(func: suspend () -> Unit) {
        if (!networkUtils.checkIfInternetConnectionIsAvailable()) {
            errorState.setValue(R.string.your_device_is_offline)
            return
        }
        viewModelScope.launch {
            loadingState.setValue(true)
            try {
                func()
            } catch (e: Exception) {
                Timber.e(e)
                errorState.setValue(R.string.an_error_has_occured)
            }
            loadingState.setValue(false)
        }
    }
}