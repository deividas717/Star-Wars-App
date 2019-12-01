package com.sample.starwarssample.ui.characters.detail

import androidx.lifecycle.viewModelScope
import com.sample.starwarssample.R
import com.sample.starwarssample.model.DisplayCharacter
import com.sample.starwarssample.ui.BaseNetworkViewModel
import com.sample.starwarssample.utils.NetworkResult
import com.sample.starwarssample.utils.NetworkUtils
import com.sample.starwarssample.utils.mapToCharacter
import kotlinx.coroutines.launch

class DetailCharacterViewModel(
    private val model: DetailCharacterModel,
    networkUtils: NetworkUtils
) : BaseNetworkViewModel(networkUtils) {

    private var url: String? = null
    internal val detailCharacterInfo = createMutableLiveData<DisplayCharacter>()
    internal val favoriteStatus = createMutableLiveData<Boolean>()

    internal fun setUrl(url: String?) {
        this.url = url
    }

    internal fun getDetailCharacterInfo() {
        url?.let { url ->
            performNetworkRequest {
                when (val networkResponse = model.getDetailCharacterInfo(url)) {
                    is NetworkResult.Success -> detailCharacterInfo.setValue(networkResponse.data)
                    is NetworkResult.Error -> errorState.setValue(R.string.an_error_has_occured)
                }
            }
        } ?: run {
            errorState.setValue(R.string.an_error_has_occured)
        }
    }

    internal fun toggleFavoriteButton() = viewModelScope.launch {
        detailCharacterInfo.value?.let { displayCharacter ->
            if (displayCharacter.isFavorite) {
                model.removeCharacter(displayCharacter.mapToCharacter())
            } else {
                model.saveCharacter(displayCharacter.mapToCharacter())
            }
            displayCharacter.isFavorite = !displayCharacter.isFavorite
            favoriteStatus.setValue(displayCharacter.isFavorite)
        }
    }
}