package com.sample.starwarssample.ui.planets

import android.os.Bundle
import android.view.View
import com.sample.starwarssample.R
import com.sample.starwarssample.model.Planet
import com.sample.starwarssample.ui.BaseFragment
import com.sample.starwarssample.ui.adapter.PlanetsAdapter
import kotlinx.android.synthetic.main.fragment_planets.*
import javax.inject.Inject

class PlanetsFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_planets

    @Inject
    internal lateinit var viewModel: PlanetsViewModel
    private val adapter = PlanetsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        planetsRecyclerView.adapter = adapter
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.planetsLiveData.observe(::setData)
        viewModel.loadingState.observe(::handleDataLoadingDialog)
    }

    private fun setData(list: List<Planet>) {
        adapter.dataList = list
    }
}
