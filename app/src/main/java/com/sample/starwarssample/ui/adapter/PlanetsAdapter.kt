package com.sample.starwarssample.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.starwarssample.R
import com.sample.starwarssample.model.Planet
import kotlinx.android.synthetic.main.planet_item_layout.view.*

class PlanetsAdapter : RecyclerView.Adapter<PlanetsAdapter.ViewHolder>() {

    var dataList: List<Planet>? = null
        set(value) {
            field = value
            notifyDataSetChanged()

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.planet_item_layout,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dataList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        dataList?.get(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(planet: Planet) {
            view.apply {
                nameTextView.text = planet.name
                rotationPeriodTextView.text = planet.rotationPeriod
                diameterTextView.text = planet.diameter
                climateTextView.text = planet.climate
            }
        }
    }
}