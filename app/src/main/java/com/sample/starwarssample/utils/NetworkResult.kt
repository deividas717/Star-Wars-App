package com.sample.starwarssample.utils

sealed class NetworkResult<out T: Any> {
    data class Success<out T : Any>(val data: T) : NetworkResult<T>()
    data class Error(val reason: String) : NetworkResult<Nothing>()
}