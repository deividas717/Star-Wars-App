package com.sample.starwarssample.ui.characters

import android.os.Bundle
import android.view.View
import com.sample.starwarssample.R
import com.sample.starwarssample.model.User
import com.sample.starwarssample.ui.BaseFragment
import timber.log.Timber
import javax.inject.Inject

class CharactersFragment : BaseFragment() {

    override val layoutId: Int = R.layout.favorite_characters_fragment

    @Inject
    internal lateinit var viewModel: CharactersViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.peoplesList.observe(::setDataList)
    }

    private fun setDataList(userList: List<User>) {
        Timber.d("setDataList() called with: userList = [${userList.size}]")
    }
}