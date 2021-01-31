package com.xrseventy.listfilm.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FilmListViewModelFactory:  ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilmListViewModel::class.java)) {
            return FilmListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

}}