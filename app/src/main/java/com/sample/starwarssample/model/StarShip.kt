package com.sample.starwarssample.model

import com.google.gson.annotations.SerializedName

data class StarShip(
    val name: String,
    val model: String,
    @SerializedName("cost_in_credits") val costInCredits: String,
    val length: String
)