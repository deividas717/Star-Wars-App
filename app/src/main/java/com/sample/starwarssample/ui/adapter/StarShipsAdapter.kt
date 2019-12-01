package com.sample.starwarssample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.starwarssample.R
import com.sample.starwarssample.model.StarShip
import kotlinx.android.synthetic.main.start_ship_item_layout.view.*

class StarShipsAdapter : RecyclerView.Adapter<StarShipsAdapter.ViewHolder>() {

    var dataList: List<StarShip>? = null
        set(value) {
            field = value
            notifyDataSetChanged()

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.start_ship_item_layout,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dataList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        dataList?.get(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(starShip: StarShip) {
            view.apply {
                nameTextView.text = starShip.name
                modelTextView.text = starShip.model
                costTextView.text = starShip.costInCredits
                lengthTextView.text = starShip.length
            }
        }
    }
}