package com.xrseventy.listfilm.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xrseventy.listfilm.data.repository.model.MovieDetails
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.ui.recyclerView.FilmListViewHolder

//class FilmsListAdapter(private val filmsList: List<MovieDetails>) :
class FilmsListAdapter(private val filmsList: List<film>) :
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
        val currentPosition = filmsList[position]
        val savedFilmListTitle = currentPosition.title
        val savedFilmListId = currentPosition.id
        val savedFilmListRating = currentPosition.rating




        holder.bind(savedFilmListTitle, savedFilmListId, savedFilmListRating)
    }


}