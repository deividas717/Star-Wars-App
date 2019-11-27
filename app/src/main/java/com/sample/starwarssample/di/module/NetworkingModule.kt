package com.sample.starwarssample.di.module

import com.sample.starwarssample.api.ApiService
import com.sample.starwarssample.di.annotation.AppScope
import com.sample.starwarssample.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class NetworkingModule private constructor() {

    @Module
    companion object {
        @Provides
        @AppScope
        @JvmStatic
        fun provideOkHttpClientBuilder(
            interceptor: HttpLoggingInterceptor
        ): OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        )

        @Provides
        @AppScope
        @JvmStatic
        fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor()

        @Provides
        @AppScope
        @JvmStatic
        fun buildRetrofitForSwapperApp(okHttpClientBuilder: OkHttpClient.Builder): Retrofit =
            Retrofit.Builder()
                .client(okHttpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.API_LINK)
                .build()

        @Provides
        @AppScope
        @JvmStatic
        fun provideApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java)
    }
}