package com.sample.starwarssample.model

import com.google.gson.annotations.SerializedName

data class Planet(
    val name: String,
    @SerializedName("rotation_period") val rotationPeriod: String,
    val diameter: String,
    val climate: String
)