package com.sample.starwarssample.ui.characters

import com.sample.starwarssample.api.ApiService
import com.sample.starwarssample.model.UsersResult
import com.sample.starwarssample.utils.NetworkResult

class CharactersModel(private val apiService: ApiService) {

    suspend fun getPeoplesByPage(pageNumber: Int) : NetworkResult<UsersResult> {
        val userResponse = apiService.getPeoplesByPage(pageNumber)
        return if (userResponse.isSuccessful) {
            NetworkResult.Success(userResponse.body()!!)
        } else {
            NetworkResult.Error("Failed to load users. Error code ${userResponse.code()}")
        }
    }
}