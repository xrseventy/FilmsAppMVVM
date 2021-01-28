package com.xrseventy.listfilm.ui.recyclerView

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xrseventy.listfilm.R

class FilmListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val inItemTitle: TextView = itemView.findViewById(R.id.inItemTitle)
    private val inItemReleaseDate: TextView = itemView.findViewById(R.id.inItemReleaseDate)
    private val inItemVoteCount: TextView = itemView.findViewById(R.id.inItemVoteCount)
    private val inItemRating: RatingBar = itemView.findViewById(R.id.ratingBar)
    private val imageViewItem: ImageView = itemView.findViewById(R.id.imageViewItem)

    fun bind(title: String, rating: Double, imageUri: String, releaseDate: String, voteCount: Int) {
        inItemTitle.text = title
        inItemRating.rating = rating.toFloat() / 2 //TODO logic go off
        inItemReleaseDate.text = releaseDate
        inItemVoteCount.text = voteCount.toString() + "reviews"

        Glide.with(itemView.context)
            .load(imageUri)
            .into(imageViewItem)
        }
}