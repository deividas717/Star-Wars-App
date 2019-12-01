package com.sample.starwarssample.di.module

import android.content.Context
import com.sample.starwarssample.StarWarsApplication
import com.sample.starwarssample.di.annotation.AppContext
import com.sample.starwarssample.utils.NetworkUtils
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule private constructor() {
    @Module
    companion object {

        @Provides
        @AppContext
        @JvmStatic
        fun provideApplicationContext(instance: StarWarsApplication): Context =
            instance.applicationContext
    }
}