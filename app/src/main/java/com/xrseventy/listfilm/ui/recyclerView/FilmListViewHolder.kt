package com.xrseventy.listfilm.ui.recyclerView

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.xrseventy.listfilm.R

class FilmListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var inItemId: TextView? = null
    private var inItemTitle: TextView? = null
    private var inItemRating: TextView? = null
    private var imageViewItem: ImageView
    private var inItemReleaseDate: TextView? = null

    init {
        inItemId = itemView.findViewById(R.id.inItemId)
        inItemTitle = itemView.findViewById(R.id.inItemTitle)
        inItemRating = itemView.findViewById(R.id.inItemRating)
        imageViewItem = itemView.findViewById(R.id.imageViewItem)
        inItemReleaseDate = itemView.findViewById(R.id.inItemReleaseDate)
    }

    fun bind(title: String, id: Int, rating: Double, imageUri: String, releaseDate: String) {
        inItemId?.text = id.toString()
        inItemTitle?.text = title
        inItemRating?.text = rating.toString()
        inItemReleaseDate?.text = releaseDate

        Glide.with(itemView.context)
            .load(imageUri)
            .into(imageViewItem)
    }


}