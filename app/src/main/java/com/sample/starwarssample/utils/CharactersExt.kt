package com.sample.starwarssample.utils

import com.sample.starwarssample.model.Character
import com.sample.starwarssample.model.DisplayCharacter

fun List<Character>.mapToDisplayCharacters(
    favorites: List<Character>? = null
): List<DisplayCharacter> {
    return map { character ->
        character.toDisplayCharacter(favorites == null || favorites.contains(character))
    }
}

fun Character.toDisplayCharacter(isFavorite: Boolean): DisplayCharacter {
    return DisplayCharacter(
        name,
        height,
        gender,
        birthYear,
        homeWorld,
        url,
        created,
        isFavorite
    )
}

fun DisplayCharacter.mapToCharacter(): Character =
    Character(name, height, gender, birthYear, homeWorld, url, created)