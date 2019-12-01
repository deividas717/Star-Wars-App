package com.sample.starwarssample.ui.starships

import com.sample.starwarssample.R
import com.sample.starwarssample.model.StarShip
import com.sample.starwarssample.ui.BaseNetworkViewModel
import com.sample.starwarssample.utils.NetworkResult
import com.sample.starwarssample.utils.NetworkUtils

class StarShipsViewModel(
    private val model: StarShipsModel,
    networkUtils: NetworkUtils
) : BaseNetworkViewModel(networkUtils) {

    internal val starShipsLiveData = createMutableLiveData<List<StarShip>>()

    init {
        getStarShips()
    }

    internal fun getStarShips() {
        performNetworkRequest {
            when (val networkResponse = model.getStarShipsByPage()) {
                is NetworkResult.Success -> starShipsLiveData.setValue(networkResponse.data.results)
                is NetworkResult.Error -> errorState.setValue(R.string.an_error_has_occured)
            }
        }
    }
}