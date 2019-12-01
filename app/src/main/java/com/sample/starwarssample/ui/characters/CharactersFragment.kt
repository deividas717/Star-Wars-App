package com.sample.starwarssample.ui.characters

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.sample.starwarssample.ui.characters.detail.DetailCharacterFragment
import com.sample.starwarssample.R
import com.sample.starwarssample.model.DisplayCharacter
import com.sample.starwarssample.ui.BaseFragment
import com.sample.starwarssample.ui.adapter.CharactersAdapter
import kotlinx.android.synthetic.main.fragment_characters.*
import javax.inject.Inject

class CharactersFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_characters
    @Inject
    internal lateinit var viewModel: CharactersViewModel
    private val adapter: CharactersAdapter = CharactersAdapter(
        ::showDetailCardItem,
        ::onFavoriteButtonPressed
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSearchViewListeners()
        charactersListRecyclerView.adapter = adapter
        observeLiveData()
    }

    override fun onErrorDialogOkPressed() {
        viewModel.getCharacters()
    }

    private fun setSearchViewListeners() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = true
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchForCharacterByName(newText)
                return true
            }
        })
    }

    private fun observeLiveData() {
        viewModel.charactersList.observe(::setDataList)
        viewModel.filteredCharactersList.observe(::setDataList)
        viewModel.loadingState.observe(::handleDataLoadingDialog)
        viewModel.errorState.observe(::showErrorDialog)
    }

    private fun setDataList(characterList: List<DisplayCharacter>) {
        adapter.characterList = characterList
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
}