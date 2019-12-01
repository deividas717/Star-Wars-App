package com.sample.starwarssample.ui.favoritecharacters

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.sample.starwarssample.R
import com.sample.starwarssample.model.DisplayCharacter
import com.sample.starwarssample.ui.BaseFragment
import com.sample.starwarssample.ui.adapter.CharactersAdapter
import com.sample.starwarssample.ui.characters.detail.DetailCharacterFragment
import kotlinx.android.synthetic.main.favorite_characters_fragment.*
import javax.inject.Inject

class FavoriteCharactersFragment : BaseFragment() {

    override val layoutId: Int = R.layout.favorite_characters_fragment

    @Inject
    internal lateinit var viewModel: FavoriteCharactersViewModel
    private val adapter: CharactersAdapter = CharactersAdapter(
        ::showDetailCardItem,
        ::onFavoriteButtonPressed
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteCharactersRecyclerView.adapter = adapter
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.favoriteCharacterList.observe(::setData)
        viewModel.loadingState.observe(::handleDataLoadingDialog)
        viewModel.errorState.observe(::showErrorDialog)
    }

    private fun setData(favoriteCharacters: List<DisplayCharacter>) {
        if (favoriteCharacters.isNotEmpty()) {
            noFavoriteCharactersTextView.visibility = View.GONE
            adapter.characterList = favoriteCharacters
        }
    }

    private fun showDetailCardItem(characterUrl: String) {
        val bundle = Bundle().apply {
            putString(DetailCharacterFragment.DETAIL_CHARACTER_URL, characterUrl)
        }
        findNavController().navigate(R.id.navigation_detail_character, bundle)
    }

    private fun onFavoriteButtonPressed(isAddedToFavorites: Boolean, character: DisplayCharacter) {
        viewModel.onFavoriteButtonPressed(isAddedToFavorites, character)
    }

    override fun onErrorDialogOkPressed() {
        // empty
    }
}
