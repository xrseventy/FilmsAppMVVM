package com.xrseventy.listfilm.presentation.viewModel

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xrseventy.listfilm.data.repository.FilmsListRepository


class FilmListViewModelFactory(private val repository: FilmsListRepository
):  ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilmListViewModel::class.java)) {
            return FilmListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

}}