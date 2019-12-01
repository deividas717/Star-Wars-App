package com.sample.starwarssample.ui.planets

import com.sample.starwarssample.api.ApiService
import com.sample.starwarssample.model.PlanetsResult
import com.sample.starwarssample.utils.NetworkResult

class PlanetsModel(private val apiService: ApiService) {

    internal suspend fun getPlanetsByPage(page: Int = 1) : NetworkResult<PlanetsResult> {
        val response = apiService.getPlanetsByPage(page)
        return if (response.isSuccessful) {
            NetworkResult.Success(response.body()!!)
        } else {
            NetworkResult.Error("Failed to load planets. Error code ${response.code()}")
        }
    }
}