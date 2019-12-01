package com.sample.starwarssample.api

import com.sample.starwarssample.model.PlanetsResult
import com.sample.starwarssample.model.StarShipResult
import com.sample.starwarssample.model.Character
import com.sample.starwarssample.model.UsersResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET("people")
    suspend fun getPeoplesByPage(@Query("page") page: Int): Response<UsersResult>

    @GET("planets")
    suspend fun getPlanetsByPage(@Query("page") page: Int): Response<PlanetsResult>

    @GET("starships")
    suspend fun getStartShipsByPage(@Query("page") page: Int): Response<StarShipResult>

    @GET
    suspend fun getDetailCharacterInfo(@Url url: String): Response<Character>
}