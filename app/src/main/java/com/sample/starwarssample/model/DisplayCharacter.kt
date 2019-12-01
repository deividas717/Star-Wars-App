package com.sample.starwarssample.model

data class DisplayCharacter(
    val name: String,
    val height: String,
    val gender: String,
    val birthYear: String,
    val homeWorld: String,
    val url: String,
    val created: String,
    var isFavorite: Boolean
)