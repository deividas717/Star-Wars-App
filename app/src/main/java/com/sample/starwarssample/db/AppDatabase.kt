package com.sample.starwarssample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sample.starwarssample.model.Character

const val STAR_WARS_DB = "StarWarsCharactersDb"
@Database(entities = [Character::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCharactersDataDao(): CharacterDataDao
}