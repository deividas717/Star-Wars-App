package com.sample.starwarssample.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Character(
    val name: String,
    val height: String,
    val gender: String,
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("homeworld")
    val homeWorld: String,
    val url: String,
    val created: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}