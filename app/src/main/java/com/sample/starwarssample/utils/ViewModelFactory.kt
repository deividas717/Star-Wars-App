package com.sample.starwarssample.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        requireNotNull(getProvider(modelClass).get()) {
            "Provider for $modelClass not found"
        }

    @Suppress("UNCHECKED_CAST")
    private fun <T : ViewModel> getProvider(modelClass: Class<T>): Provider<T> =
        try {
            modelClass as Class<ViewModel>
            requireNotNull(providers[modelClass] as Provider<T>) {
                "No ViewModel provider is bound for class $modelClass"
            }
        } catch (cce: ClassCastException) {
            error("Wrong provider type registered for ViewModel type $modelClass")
        }
}