package com.sample.starwarssample.di.module

import android.content.Context
import androidx.room.Room
import com.sample.starwarssample.db.AppDatabase
import com.sample.starwarssample.db.STAR_WARS_DB
import com.sample.starwarssample.di.annotation.AppContext
import com.sample.starwarssample.di.annotation.AppScope
import dagger.Module
import dagger.Provides

@Module
abstract class StorageModule private constructor() {
    @Module
    companion object {
        @Provides
        @AppScope
        @JvmStatic
        fun provideConnectedDeepersDb(
            @AppContext context: Context
        ): AppDatabase =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                STAR_WARS_DB
            ).build()
    }
}