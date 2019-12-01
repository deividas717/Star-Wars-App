package com.sample.starwarssample.ui.characters.detail

import android.os.Bundle
import android.view.View
import com.sample.starwarssample.R
import com.sample.starwarssample.model.Character
import com.sample.starwarssample.model.DisplayCharacter
import com.sample.starwarssample.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_detail_character.*
import kotlinx.android.synthetic.main.user_item_layout.view.*
import javax.inject.Inject

class DetailCharacterFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_detail_character

    @Inject
    internal lateinit var viewModel: DetailCharacterViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()

        val url = arguments?.getString(DETAIL_CHARACTER_URL)
        viewModel.getDetailCharacterInfo(url)
    }

    private fun observeLiveData() {
        viewModel.detailCharacterInfo.observe(::setDetailCharacterInfo)
        viewModel.loadingState.observe(::handleDataLoadingDialog)
    }

    private fun setDetailCharacterInfo(character: DisplayCharacter) {
        detailCharacterLayout.apply {
            nameTextView.text = character.name
            nameTextView.text = character.name
            heightTextView.text = character.height
            genderTextView.text = character.gender
            birthYearTextView.text = character.birthYear
            homeWorldTextView.text = character.homeWorld
            favoriteButton.setImageResource(getFavoriteIcon((character)))
        }
    }

    private fun getFavoriteIcon(character: DisplayCharacter): Int =
        if (character.isFavorite) {
            R.drawable.ic_star
        } else {
            R.drawable.ic_star_border
        }

    companion object {
        const val DETAIL_CHARACTER_URL = "DetailCharacterUrl"
    }
}
