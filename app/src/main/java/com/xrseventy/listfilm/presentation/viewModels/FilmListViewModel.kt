package com.xrseventy.listfilm.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xrseventy.listfilm.data.network.LoadFilmListCallBack
import com.xrseventy.listfilm.data.repository.FilmsListRepository
import com.xrseventy.listfilm.data.model.MovieItem

import com.xrseventy.listfilm.presentation.FilmListFragmentScreenState

class FilmListViewModel(private val filmsListRepository: FilmsListRepository) : ViewModel() {

    private var _movieList: MutableLiveData<List<MovieItem>> = MutableLiveData()
    var movieList: LiveData<List<MovieItem>> = _movieList


    private var screenState: FilmListFragmentScreenState = FilmListFragmentScreenState(
        showProgressBar = false,
        showErrorMessage = false,
        itemClicked = false,
        btnRetryClicked = false
    )


    fun loadMovieList() {
        updateScreenState(showProgressBar = true)
        // movieList = filmsListRepository.getListOfPopularMovies()


        filmsListRepository.fetchMovieListFromResponseTask(object : LoadFilmListCallBack {
            //filmsListRepository.fetchMovieListFromResponseTask(object : LoadFilmListCallBack {
            override fun onSuccess(listMovieItem: List<MovieItem>) {
                _movieList.value = listMovieItem
                updateScreenState(
                    showErrorMessage = false,
                    showProgressBar = false
                )
            }

            override fun onError() {
                updateScreenState(
                    showErrorMessage = true
                )
            }

        })
    }


    private fun updateScreenState(
        showProgressBar: Boolean = screenState.showProgressBar,
        showErrorMessage: Boolean = screenState.showErrorMessage,
        itemClicked: Boolean = screenState.itemClicked,
        btnRetryClicked: Boolean = screenState.btnRetryClicked
    ) {
        screenState = FilmListFragmentScreenState(
            showProgressBar,
            showErrorMessage,
            itemClicked,
            btnRetryClicked,
        )
    }

}

