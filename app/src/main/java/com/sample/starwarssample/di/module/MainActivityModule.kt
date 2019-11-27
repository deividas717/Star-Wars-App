package com.sample.starwarssample.di.module

import com.sample.starwarssample.di.annotation.DaggerScope
import com.sample.starwarssample.ui.characters.CharactersFragment
import com.sample.starwarssample.ui.planets.PlanetsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule private constructor() {

    @DaggerScope(CharactersFragment::class)
    @ContributesAndroidInjector(modules = [CharactersFragmentModule::class])
    abstract fun provideLoginFragment(): CharactersFragment

    @DaggerScope(PlanetsFragment::class)
    @ContributesAndroidInjector(modules = [PlanetsFragmentModule::class])
    abstract fun providePlanetsFragment(): PlanetsFragment
}