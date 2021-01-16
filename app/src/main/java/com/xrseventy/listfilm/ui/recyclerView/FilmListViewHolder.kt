package com.xrseventy.listfilm.ui.recyclerView

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xrseventy.listfilm.R

class FilmListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var inItemId: TextView? = null
    private var inItemTitle: TextView? = null
    private var inItemRating: TextView? = null

    init {
        inItemId = itemView.findViewById(R.id.inItemId)
        inItemTitle = itemView.findViewById(R.id.inItemTitle)
        inItemRating = itemView.findViewById(R.id.inItemRating)
    }

    fun bind(title: String, id: Int, rating: Double) {
        inItemId?.text = id.toString()
        inItemTitle?.text = title
        inItemRating?.text = rating.toString()
    }
}