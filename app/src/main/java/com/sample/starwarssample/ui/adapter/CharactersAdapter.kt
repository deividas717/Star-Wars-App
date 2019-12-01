package com.sample.starwarssample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.starwarssample.R
import com.sample.starwarssample.model.DisplayCharacter
import kotlinx.android.synthetic.main.user_item_layout.view.*

typealias CharacterItemClick = (String) -> Unit
typealias SaveButtonClick = (Boolean, DisplayCharacter) -> Unit

class CharactersAdapter(
    private val itemClickListener: CharacterItemClick,
    private val saveButtonListener: SaveButtonClick
) : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    var characterList: List<DisplayCharacter>? = null
        set(value) {
            field = value
            notifyDataSetChanged()

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.user_item_layout,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = characterList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        characterList?.get(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.characterCardView.setOnClickListener {
                characterList?.get(adapterPosition)?.let { character ->
                    itemClickListener(character.url)
                }
            }
            view.characterCardView.favoriteButton.setOnClickListener {
                characterList?.get(adapterPosition)?.let { character ->
                    if (character.isFavorite) {
                        character.isFavorite = false
                        view.favoriteButton.setImageResource(R.drawable.ic_star_border)
                        saveButtonListener(false, character)
                    } else {
                        character.isFavorite = true
                        view.favoriteButton.setImageResource(R.drawable.ic_star)
                        saveButtonListener(true, character)
                    }
                    notifyItemChanged(adapterPosition)
                }
            }
        }

        fun bind(character: DisplayCharacter) {
            view.apply {
                nameTextView.text = character.name
                heightTextView.text = character.height
                genderTextView.text = character.gender
                birthYearTextView.text = character.birthYear
                homeWorldTextView.text = character.homeWorld
                favoriteButton.setImageResource(getFavoriteIcon(character))
            }
        }

        private fun getFavoriteIcon(character: DisplayCharacter): Int =
            if (character.isFavorite) {
                R.drawable.ic_star
            } else {
                R.drawable.ic_star_border
            }
    }
}