package com.sample.starwarssample.di.module

import com.sample.starwarssample.ui.characters.detail.DetailCharacterFragment
import com.sample.starwarssample.di.annotation.DaggerScope
import com.sample.starwarssample.ui.characters.CharactersFragment
import com.sample.starwarssample.ui.favoritecharacters.FavoriteCharactersFragment
import com.sample.starwarssample.ui.planets.PlanetsFragment
import com.sample.starwarssample.ui.starships.StarShipsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule private constructor() {

    @DaggerScope(CharactersFragment::class)
    @ContributesAndroidInjector(modules = [CharactersFragmentModule::class])
    abstract fun provideCharactersFragment(): CharactersFragment

    @DaggerScope(DetailCharacterFragment::class)
    @ContributesAndroidInjector(modules = [DetailCharacterFragmentModule::class])
    abstract fun provideDetailCharacterFragment(): DetailCharacterFragment

    @DaggerScope(PlanetsFragment::class)
    @ContributesAndroidInjector(modules = [PlanetsFragmentModule::class])
    abstract fun providePlanetsFragment(): PlanetsFragment

    @DaggerScope(StarShipsFragment::class)
    @ContributesAndroidInjector(modules = [StarShipsFragmentModule::class])
    abstract fun provideStarShipsFragment(): StarShipsFragment

    @DaggerScope(FavoriteCharactersFragment::class)
    @ContributesAndroidInjector(modules = [FavoriteCharactersFragmentModule::class])
    abstract fun provideFavoriteCharactersFragment(): FavoriteCharactersFragment
}