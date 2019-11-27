package com.sample.starwarssample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutId, container, false)

    protected fun <T> LiveData<T>.observe(action: (T) -> Unit) {
        observe(viewLifecycleOwner, Observer { data -> data?.let(action) })
    }
}