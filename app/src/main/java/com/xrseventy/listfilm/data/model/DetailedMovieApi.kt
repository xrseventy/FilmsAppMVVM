package com.xrseventy.listfilm.data.model

import java.util.*

open class DetailedMovieApi(
    val id: Int,
    val genres: List<Genre>,
    val title: String,
    val overview: String,
    val release_date: Date,
    val vote_average: Double,
    val vote_count: Int,
    val poster_path: String,
)

class Genre(
    val id: Int,
    val name: String
)