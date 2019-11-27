package com.sample.starwarssample.di.module

import com.sample.starwarssample.MainActivity
import com.sample.starwarssample.di.annotation.DaggerScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {

    @DaggerScope(MainActivity::class)
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun provideMainActivity(): MainActivity
}