package com.xrseventy.listfilm.presentation.filmListRecyclerView

import FilmListClickListener
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.data.model.MovieItem

class FilmListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val inItemTitle: TextView = itemView.findViewById(R.id.inItemTitle)
    val inItemReleaseDate: TextView = itemView.findViewById(R.id.inItemReleaseDate)
    val inItemVoteCount: TextView = itemView.findViewById(R.id.inItemVoteCount)
    val inItemRating: RatingBar = itemView.findViewById(R.id.ratingBar)
    private val imageViewItem: ImageView = itemView.findViewById(R.id.imageViewItem)

    fun bind(posterPath: String, filmListClickListener: FilmListClickListener, currentItemPosition: MovieItem) {


        itemView.setOnClickListener {
            currentItemPosition.run { filmListClickListener.onItemClick(this) }
            Log.d(this.toString(), "Listener work ${currentItemPosition.title}")
        }

        Glide.with(itemView.context)
                .load(posterPath)
                .into(imageViewItem)
    }
}