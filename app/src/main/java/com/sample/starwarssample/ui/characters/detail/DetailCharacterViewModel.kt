package com.sample.starwarssample.ui.characters.detail

import com.sample.starwarssample.R
import com.sample.starwarssample.model.DisplayCharacter
import com.sample.starwarssample.ui.BaseNetworkViewModel
import com.sample.starwarssample.utils.NetworkResult
import com.sample.starwarssample.utils.NetworkUtils

class DetailCharacterViewModel(
    private val model: DetailCharacterModel,
    networkUtils: NetworkUtils
) : BaseNetworkViewModel(networkUtils) {

    val detailCharacterInfo = createSingleLiveData<DisplayCharacter>()

    internal fun getDetailCharacterInfo(url: String?) {
        if (url == null) {
            errorState.setValue(R.string.an_error_has_occured)
            return
        }

        performNetworkRequest {
            when (val networkResponse = model.getDetailCharacterInfo(url)) {
                is NetworkResult.Success -> detailCharacterInfo.setValue(networkResponse.data)
                is NetworkResult.Error -> errorState.setValue(R.string.an_error_has_occured)
            }
        }
    }
}