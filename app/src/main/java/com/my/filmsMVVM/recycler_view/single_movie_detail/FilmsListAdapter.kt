package com.my.filmsMVVM.recycler_view.single_movie_detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.my.filmsMVVM.data.response.MovieDetails
import com.my.weather.R

class FilmsListAdapter(private val filmsList: List<MovieDetails>) :
    RecyclerView.Adapter<FilmsListAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.films_list_fragment, parent, false)
        )
    }

    override fun getItemCount() = filmsList.size

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
        val movie = filmsList[position]
        holder.view.textViewTitle.text = movie.title
        holder.view.textViewLanguage.text = movie.language
        holder.view.textViewType.text = movie.type
        holder.view.textViewRating.text = movie.rating
        holder.view.textViewLikePercent.text = movie.likePercent.toString() + "%"
        holder.view.textViewVotesCount.text = movie.voteCount.toString() + " votes"
        holder.view.textViewIsNew.visibility =
            if (movie.isNew == 1) View.VISIBLE else View.INVISIBLE

        Glide.with(holder.view.context)
            .load(movie.image)
            .into(holder.view.imageView)
    }


    class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
}