package com.xrseventy.listfilm.data.model
import com.google.gson.annotations.SerializedName
import java.util.*

class PopularMoviesList(
    val page: Int,
    val results: List<MovieItem>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

class MovieItem(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val id: Int,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: Date,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)