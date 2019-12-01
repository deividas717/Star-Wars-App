package com.sample.starwarssample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.sample.starwarssample.api.ApiService
import com.sample.starwarssample.di.annotation.ViewModelKey
import com.sample.starwarssample.ui.starships.StarShipsFragment
import com.sample.starwarssample.ui.starships.StarShipsModel
import com.sample.starwarssample.ui.starships.StarShipsViewModel
import com.sample.starwarssample.utils.NetworkUtils
import com.sample.starwarssample.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class StarShipsFragmentModule private constructor() {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideStarShipsModel(apiService: ApiService): StarShipsModel =
            StarShipsModel(apiService)

        @JvmStatic
        @Provides
        fun provideStarShipsViewModel(
            target: StarShipsFragment,
            factory: ViewModelFactory
        ): StarShipsViewModel =
            ViewModelProviders.of(target, factory).get(StarShipsViewModel::class.java)

        @JvmStatic
        @Provides
        @IntoMap
        @ViewModelKey(StarShipsViewModel::class)
        fun provideStarShipsViewModelFactory(
            model: StarShipsModel,
            networkUtils: NetworkUtils
        ): ViewModel = StarShipsViewModel(model, networkUtils)
    }
}