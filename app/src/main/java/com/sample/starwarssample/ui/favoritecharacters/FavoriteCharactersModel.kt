package com.sample.starwarssample.ui.favoritecharacters

import com.sample.starwarssample.db.AppDatabase
import com.sample.starwarssample.model.Character

class FavoriteCharactersModel(private val db: AppDatabase) {

    internal suspend fun getAllCharacters() : List<Character> =
        db.getCharactersDataDao().getAllCharacters() ?: emptyList()

    internal suspend fun saveCharacter(character: Character) {
        db.getCharactersDataDao().saveCharacter(character)
    }

    internal suspend fun removeCharacter(character: Character) {
        db.getCharactersDataDao().removeCharacter(character.url)
    }
}