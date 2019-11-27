package com.sample.starwarssample

import com.sample.starwarssample.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class StarWarsApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}