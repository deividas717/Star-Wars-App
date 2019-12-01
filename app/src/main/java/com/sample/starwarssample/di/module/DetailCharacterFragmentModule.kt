package com.sample.starwarssample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.sample.starwarssample.api.ApiService
import com.sample.starwarssample.db.AppDatabase
import com.sample.starwarssample.di.annotation.ViewModelKey
import com.sample.starwarssample.ui.characters.detail.DetailCharacterFragment
import com.sample.starwarssample.ui.characters.detail.DetailCharacterModel
import com.sample.starwarssample.ui.characters.detail.DetailCharacterViewModel
import com.sample.starwarssample.utils.NetworkUtils
import com.sample.starwarssample.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class DetailCharacterFragmentModule private constructor() {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideDetailCharacterModel(
            apiService: ApiService,
            db: AppDatabase
        ): DetailCharacterModel = DetailCharacterModel(apiService, db)

        @JvmStatic
        @Provides
        fun provideDetailCharacterViewModel(
            target: DetailCharacterFragment,
            factory: ViewModelFactory
        ): DetailCharacterViewModel =
            ViewModelProviders.of(target, factory).get(DetailCharacterViewModel::class.java)

        @JvmStatic
        @Provides
        @IntoMap
        @ViewModelKey(DetailCharacterViewModel::class)
        fun provideDetailCharacterViewModelFactory(
            model: DetailCharacterModel,
            networkUtils: NetworkUtils
        ): ViewModel = DetailCharacterViewModel(model, networkUtils)
    }
}