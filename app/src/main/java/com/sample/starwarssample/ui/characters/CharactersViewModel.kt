package com.sample.starwarssample.ui.characters

import androidx.lifecycle.viewModelScope
import com.sample.starwarssample.R
import com.sample.starwarssample.model.DisplayCharacter
import com.sample.starwarssample.ui.BaseNetworkViewModel
import com.sample.starwarssample.utils.NetworkResult
import com.sample.starwarssample.utils.NetworkUtils
import com.sample.starwarssample.utils.mapToCharacter
import com.sample.starwarssample.utils.mapToDisplayCharacters
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val model: CharactersModel,
    networkUtils: NetworkUtils
) : BaseNetworkViewModel(networkUtils) {

    internal val charactersList = createMutableLiveData<List<DisplayCharacter>>()
    internal val filteredCharactersList = createMutableLiveData<List<DisplayCharacter>>()

    init {
        getCharacters()
    }

    internal fun getCharacters() {
        performNetworkRequest {
            val favoriteCharacters = model.getAllCharacters()
            when (val networkResponse = model.getPeoplesByPage()) {
                is NetworkResult.Success -> {
                    val characters = networkResponse.data.result.mapToDisplayCharacters(
                        favoriteCharacters
                    )
                    charactersList.setValue(characters)
                }
                is NetworkResult.Error -> errorState.setValue(R.string.an_error_has_occured)
            }
        }
    }
    internal fun searchForCharacterByName(text: String) {
        val filteredList = charactersList.value?.filter { it.name.contains(text, true) } ?: return
        filteredCharactersList.setValue(filteredList)
    }

    internal fun onFavoriteButtonPressed(addedToFavorites: Boolean, character: DisplayCharacter) =
        viewModelScope.launch {
            if (addedToFavorites) {
                model.saveCharacter(character.mapToCharacter())
            } else {
                model.removeCharacter(character.mapToCharacter())
            }
        }
}