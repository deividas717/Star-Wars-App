package com.sample.starwarssample.model

import com.google.gson.annotations.SerializedName

data class StarShip(
    val name: String,
    val model: String,
    val manufacturer: String,
    @SerializedName("cost_in_credits") val costInCredits: String,
    val length: String,
    val crew: String,
    val passengers: String,
    val consumables: String,
    @SerializedName("starship_class") val starShipClass: String,
    val url: String,
    val films: List<String>,
    val pilots: List<String>
)