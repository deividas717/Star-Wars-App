package com.sample.starwarssample.ui.favoritecharacters

import androidx.lifecycle.viewModelScope
import com.sample.starwarssample.model.DisplayCharacter
import com.sample.starwarssample.ui.BaseViewModel
import com.sample.starwarssample.utils.mapToCharacter
import com.sample.starwarssample.utils.mapToDisplayCharacters
import kotlinx.coroutines.launch

class FavoriteCharactersViewModel(private val model: FavoriteCharactersModel) : BaseViewModel() {

    internal val favoriteCharacterList = createMutableLiveData<List<DisplayCharacter>>()

    init {
        viewModelScope.launch {
            loadingState.setValue(true)
            val displayCharacters = model.getAllCharacters().mapToDisplayCharacters()
            favoriteCharacterList.setValue(displayCharacters)
            loadingState.setValue(false)
        }
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
