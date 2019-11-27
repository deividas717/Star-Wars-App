package com.sample.starwarssample.model

import com.google.gson.annotations.SerializedName

data class User(
    val name: String,
    val height: String,
    val gender: String,
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("homeworld")
    val homeWorld: String,
    val url: String,
    val films: List<String>,
    val species: List<String>,
    val vehicles: List<String>,
    @SerializedName("starships")
    val starShips: List<String>
)