package com.sample.starwarssample.ui.starships

import android.os.Bundle
import android.view.View
import com.sample.starwarssample.R
import com.sample.starwarssample.model.StarShip
import com.sample.starwarssample.ui.BaseFragment
import com.sample.starwarssample.ui.adapter.StarShipsAdapter
import kotlinx.android.synthetic.main.fragment_starships.*
import javax.inject.Inject

class StarShipsFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_starships
    private val adapter = StarShipsAdapter()
    @Inject
    internal lateinit var viewModel: StarShipsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        starShipsRecyclerView.adapter = adapter
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.starShipsLiveData.observe(::setData)
        viewModel.loadingState.observe(::handleDataLoadingDialog)
        viewModel.errorState.observe(::showErrorDialog)
    }

    private fun setData(data: List<StarShip>) {
        adapter.dataList = data
    }

    override fun onErrorDialogOkPressed() {
        viewModel.getStarShips()
    }
}