package com.sample.starwarssample.di.component

import com.sample.starwarssample.StarWarsApplication
import com.sample.starwarssample.di.annotation.AppScope
import com.sample.starwarssample.di.module.AppModule
import com.sample.starwarssample.di.module.MainActivityModule
import com.sample.starwarssample.di.module.NetworkingModule
import com.sample.starwarssample.di.module.StorageModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        NetworkingModule::class,
        MainActivityModule::class,
        StorageModule::class
    ]
)
interface AppComponent : AndroidInjector<StarWarsApplication> {
    /**
     * AppComponent Builder interface. All implementation part is handled by a dagger compiler.
     */
    @Component.Factory
    interface Factory : AndroidInjector.Factory<StarWarsApplication>
}