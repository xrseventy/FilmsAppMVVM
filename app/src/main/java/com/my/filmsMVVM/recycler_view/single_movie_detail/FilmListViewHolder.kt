package com.my.filmsMVVM.recycler_view.single_movie_detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FilmListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(location: String, distance: Double) {
        itemView.inItemLocation.text = location
        itemView.inItemDistance.text = distance.toString()
    }
}