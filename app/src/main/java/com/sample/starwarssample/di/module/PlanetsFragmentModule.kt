package com.sample.starwarssample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.sample.starwarssample.api.ApiService
import com.sample.starwarssample.di.annotation.ViewModelKey
import com.sample.starwarssample.ui.characters.CharactersFragment
import com.sample.starwarssample.ui.characters.CharactersModel
import com.sample.starwarssample.ui.characters.CharactersViewModel
import com.sample.starwarssample.ui.planets.PlanetsFragment
import com.sample.starwarssample.ui.planets.PlanetsModel
import com.sample.starwarssample.ui.planets.PlanetsViewModel
import com.sample.starwarssample.utils.NetworkUtils
import com.sample.starwarssample.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class PlanetsFragmentModule private constructor() {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providePlanetsModel(apiService: ApiService): PlanetsModel =
            PlanetsModel(apiService)

        @JvmStatic
        @Provides
        fun providePlanetsModelViewModel(
            target: PlanetsFragment,
            factory: ViewModelFactory
        ): PlanetsViewModel =
            ViewModelProviders.of(target, factory).get(PlanetsViewModel::class.java)

        @JvmStatic
        @Provides
        @IntoMap
        @ViewModelKey(PlanetsViewModel::class)
        fun providePlanetsViewModelFactory(
            model: PlanetsModel,
            networkUtils: NetworkUtils
        ): ViewModel = PlanetsViewModel(model, networkUtils)
    }
}