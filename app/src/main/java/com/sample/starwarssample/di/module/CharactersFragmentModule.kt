package com.sample.starwarssample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.sample.starwarssample.api.ApiService
import com.sample.starwarssample.db.AppDatabase
import com.sample.starwarssample.di.annotation.ViewModelKey
import com.sample.starwarssample.ui.characters.CharactersFragment
import com.sample.starwarssample.ui.characters.CharactersModel
import com.sample.starwarssample.ui.characters.CharactersViewModel
import com.sample.starwarssample.utils.NetworkUtils
import com.sample.starwarssample.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class CharactersFragmentModule private constructor() {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideCharactersModel(apiService: ApiService, db: AppDatabase): CharactersModel =
            CharactersModel(apiService, db)

        @JvmStatic
        @Provides
        fun provideCharactersViewModel(
            target: CharactersFragment,
            factory: ViewModelFactory
        ): CharactersViewModel =
            ViewModelProviders.of(target, factory).get(CharactersViewModel::class.java)

        @JvmStatic
        @Provides
        @IntoMap
        @ViewModelKey(CharactersViewModel::class)
        fun provideCharactersViewModelFactory(
            model: CharactersModel,
            networkUtils: NetworkUtils
        ): ViewModel = CharactersViewModel(model, networkUtils)
    }
}