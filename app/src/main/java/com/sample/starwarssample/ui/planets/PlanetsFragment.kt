package com.sample.starwarssample.ui.planets

import com.sample.starwarssample.R
import com.sample.starwarssample.ui.BaseFragment
import javax.inject.Inject

class PlanetsFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_home

    @Inject
    internal lateinit var viewModel: PlanetsViewModel

    //private lateinit var planetsViewModel: PlanetsViewModel
}