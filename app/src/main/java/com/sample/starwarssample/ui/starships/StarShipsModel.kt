package com.sample.starwarssample.ui.starships

import com.sample.starwarssample.api.ApiService
import com.sample.starwarssample.model.StarShipResult
import com.sample.starwarssample.utils.NetworkResult

class StarShipsModel(private val apiService: ApiService) {

    internal suspend fun getStarShipsByPage(page: Int = 1)  : NetworkResult<StarShipResult> {
        val response = apiService.getStartShipsByPage(page)
        return if (response.isSuccessful) {
            NetworkResult.Success(response.body()!!)
        } else {
            NetworkResult.Error("Failed to load starships. Error code ${response.code()}")
        }
    }
}