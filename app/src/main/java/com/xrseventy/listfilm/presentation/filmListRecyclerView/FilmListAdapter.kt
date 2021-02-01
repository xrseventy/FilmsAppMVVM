package com.xrseventy.listfilm.presentation.filmListRecyclerView
import FilmListClickListener
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.my.listFilms.data.repository.remote_data_source.NetworkModule.POSTER_BASE_URL
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.data.model.MovieItem



class FilmListAdapter(
    private val filmsList: List<MovieItem>,
    private val filmListClickListener: FilmListClickListener
) :
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
        val savedFilmPosterPath = currentPosition.posterPath
        val posterPath = POSTER_BASE_URL + savedFilmPosterPath

        Log.d(this.toString(), "posterPath $posterPath")
        holder.bind(posterPath, filmListClickListener, currentPosition)
        bindView(holder, currentPosition)
    }

    private fun bindView(viewHolder: FilmListViewHolder, currentPosition: MovieItem ){
        viewHolder.inItemTitle.text = currentPosition.title
        viewHolder.inItemRating.rating = currentPosition.voteAverage.toFloat() / 2 //TODO logic go off
        viewHolder.inItemReleaseDate.text = currentPosition.releaseDate
        viewHolder.inItemVoteCount.text = currentPosition.voteCount.toString() + " reviews" //TODO plurals res
    }
}