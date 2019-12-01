package com.sample.starwarssample.ui.characters

import com.sample.starwarssample.api.ApiService
import com.sample.starwarssample.db.AppDatabase
import com.sample.starwarssample.model.Character
import com.sample.starwarssample.model.UsersResult
import com.sample.starwarssample.utils.NetworkResult

class CharactersModel(private val apiService: ApiService, private val db: AppDatabase) {

    internal suspend fun getPeoplesByPage(pageNumber: Int = 1) : NetworkResult<UsersResult> {
        val userResponse = apiService.getPeoplesByPage(pageNumber)
        return if (userResponse.isSuccessful) {
            NetworkResult.Success(userResponse.body()!!)
        } else {
            NetworkResult.Error("Failed to load users. Error code ${userResponse.code()}")
        }
    }

    internal suspend fun getAllCharacters() : List<Character> =
        db.getCharactersDataDao().getAllCharacters() ?: emptyList()

    internal suspend fun saveCharacter(character: Character) {
        db.getCharactersDataDao().saveCharacter(character)
    }

    internal suspend fun removeCharacter(character: Character) {
        db.getCharactersDataDao().removeCharacter(character.url)
    }
}