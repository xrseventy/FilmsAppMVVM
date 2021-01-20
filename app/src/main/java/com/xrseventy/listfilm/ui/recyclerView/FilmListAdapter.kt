package com.xrseventy.listfilm.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import com.my.listFilms.data.repository.remote_data_source.NetworkModule.POSTER_BASE_URL
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.data.repository.model.MovieItem
import com.xrseventy.listfilm.data.repository.model.PopularMoviesList
import com.xrseventy.listfilm.ui.recyclerView.FilmListViewHolder

class FilmsListAdapter(private val filmsList: List<MovieItem>) :
//class FilmsListAdapter(private val filmsList: List<film>) :
    RecyclerView.Adapter<FilmListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.film_card_in_list,
            parent,
            false
        )
        return FilmListViewHolder(v)
    }

    override fun getItemCount() = filmsList.size

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
        val currentPosition = filmsList.get(position)
        val savedFilmListTitle = currentPosition.title
        val savedFilmListId = currentPosition.id
        val savedFilmListRating = currentPosition.voteAverage
        val savedFilmPosterPath = currentPosition.posterPath
        val posterPath = POSTER_BASE_URL + savedFilmPosterPath
        val releaseDate = currentPosition.releaseDate
        Log.d(this.toString(), "posterPath $posterPath")

        holder.bind(savedFilmListTitle, savedFilmListId, savedFilmListRating,posterPath, releaseDate)

    }


}