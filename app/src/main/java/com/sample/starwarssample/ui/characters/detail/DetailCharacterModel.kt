package com.sample.starwarssample.ui.characters.detail

import com.sample.starwarssample.api.ApiService
import com.sample.starwarssample.db.AppDatabase
import com.sample.starwarssample.model.DisplayCharacter
import com.sample.starwarssample.utils.NetworkResult
import com.sample.starwarssample.utils.toDisplayCharacter

class DetailCharacterModel(private val apiService: ApiService, private val db: AppDatabase) {

    internal suspend fun getDetailCharacterInfo(url: String) : NetworkResult<DisplayCharacter> {
        val favoriteCharacter = db.getCharactersDataDao().getSpecificCharacter(url)
        if (favoriteCharacter != null) {
            return NetworkResult.Success(favoriteCharacter.toDisplayCharacter(true))
        }
        val response = apiService.getDetailCharacterInfo(url)
        return if (response.isSuccessful) {
            NetworkResult.Success(response.body()!!.toDisplayCharacter(false))
        } else {
            NetworkResult.Error("Failed to load detail character info. Error code ${response.code()}")
        }
    }
}