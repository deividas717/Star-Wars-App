package com.sample.starwarssample.ui.characters

import androidx.lifecycle.viewModelScope
import com.sample.starwarssample.model.User
import com.sample.starwarssample.ui.BaseViewModel
import com.sample.starwarssample.utils.NetworkResult
import kotlinx.coroutines.launch

class CharactersViewModel(private val model: CharactersModel) : BaseViewModel() {

    val peoplesList = createMutableLiveData<List<User>>()

    init {
        viewModelScope.launch {
            when (val networkResponse = model.getPeoplesByPage(1)) {
                is NetworkResult.Success -> peoplesList.setValue(networkResponse.data.result)
                is NetworkResult.Error -> errorState.setValue(networkResponse.reason)
            }
        }
    }
}