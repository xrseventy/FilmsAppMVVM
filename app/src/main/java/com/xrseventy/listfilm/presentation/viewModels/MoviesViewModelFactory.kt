package com.xrseventy.listfilm.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xrseventy.listfilm.data.repository.FilmsListRepository


class MoviesViewModelFactory(private val repository: FilmsListRepository
):  ViewModelProvider.Factory{
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(FilmListViewModel::class.java)) {
//            return FilmListViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =  when (modelClass) {
        FilmListViewModel::class.java -> FilmListViewModel(repository) as T
        DetailedFilmViewModel::class.java -> DetailedFilmViewModel(repository) as T
        else -> throw IllegalArgumentException("Unknown ViewModel class")
    }


}