package com.sample.starwarssample.db

import androidx.room.*
import com.sample.starwarssample.model.Character

@Dao
interface CharacterDataDao {

    @Query("SELECT * FROM `Character`")
    suspend fun getAllCharacters() : List<Character>?

    @Query("SELECT * FROM `Character` WHERE `url` = :url")
    suspend fun getSpecificCharacter(url: String): Character?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun saveCharacter(characterData: Character)

    @Query("DELETE FROM `Character` WHERE `url` = :url")
    suspend fun removeCharacter(url: String)
}