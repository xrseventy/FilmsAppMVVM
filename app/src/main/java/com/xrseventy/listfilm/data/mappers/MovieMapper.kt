//package com.xrseventy.listfilm.data.mappers
//
//import com.xrseventy.listfilm.data.model.DetailedMovieApi
//import com.xrseventy.listfilm.data.model.Genre
//import com.xrseventy.listfilm.data.model.MovieItem
//import com.xrseventy.listfilm.domain.models.DetailedMovie
//
//class MovieMapper {
//    fun mapShortMovieInfo(item: MovieItem): MovieItem = MovieItem(
//        backdropPath = item.backdropPath,
//        id = item.id,
//        popularity = item.popularity,
//        posterPath = item.posterPath,
//        releaseDate = item.releaseDate,
//        voteAverage = item.voteAverage,
//        title = item.title,
//        voteCount = item.voteCount,
//    )
//
//    fun mapDetailedMovieInfo(item: DetailedMovieApi): DetailedMovie = DetailedMovie(
//        id = item.id,
//        overview = item.overview,
//        title = item.title,
//        genres = mapGenres(item.genres),
//        poster_path = item.poster_path,
//        release_date = item.release_date,
//        vote_average = item.vote_average,
//        vote_count = item.vote_count
//    )
//
//    private fun mapGenres(listGenres: List<Genre>): List<Genre> =
//        listGenres.map(::mapGenre)
//
//    private fun mapGenre(item: Genre): Genre = Genre(
//        id = item.id,
//        name = item.name
//    )
//
//
//}