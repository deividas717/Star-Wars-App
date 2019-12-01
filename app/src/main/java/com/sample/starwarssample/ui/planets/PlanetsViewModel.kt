package com.sample.starwarssample.ui.planets

import com.sample.starwarssample.R
import com.sample.starwarssample.model.Planet
import com.sample.starwarssample.ui.BaseNetworkViewModel
import com.sample.starwarssample.utils.NetworkResult
import com.sample.starwarssample.utils.NetworkUtils

class PlanetsViewModel(
    private val model: PlanetsModel,
    networkUtils: NetworkUtils
) : BaseNetworkViewModel(networkUtils) {

    internal val planetsLiveData = createMutableLiveData<List<Planet>>()

    init {
        getPlanets()
    }

    internal fun getPlanets() {
        performNetworkRequest {
            when (val networkResponse = model.getPlanetsByPage()) {
                is NetworkResult.Success -> planetsLiveData.setValue(networkResponse.data.result)
                is NetworkResult.Error -> errorState.setValue(R.string.an_error_has_occured)
            }
        }
    }
}