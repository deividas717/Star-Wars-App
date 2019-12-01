package com.sample.starwarssample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.sample.starwarssample.db.AppDatabase
import com.sample.starwarssample.di.annotation.ViewModelKey
import com.sample.starwarssample.ui.favoritecharacters.FavoriteCharactersFragment
import com.sample.starwarssample.ui.favoritecharacters.FavoriteCharactersModel
import com.sample.starwarssample.ui.favoritecharacters.FavoriteCharactersViewModel
import com.sample.starwarssample.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class FavoriteCharactersFragmentModule private constructor() {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideFavoriteCharactersModule(db: AppDatabase): FavoriteCharactersModel =
            FavoriteCharactersModel(db)

        @JvmStatic
        @Provides
        fun provideFavoriteCharactersViewModel(
            target: FavoriteCharactersFragment,
            factory: ViewModelFactory
        ): FavoriteCharactersViewModel =
            ViewModelProviders.of(target, factory).get(FavoriteCharactersViewModel::class.java)

        @JvmStatic
        @Provides
        @IntoMap
        @ViewModelKey(FavoriteCharactersViewModel::class)
        fun provideFavoriteCharactersViewModelFactory(model: FavoriteCharactersModel): ViewModel =
            FavoriteCharactersViewModel(model)
    }
}