package com.xrseventy.listfilm.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xrseventy.listfilm.data.network.LoadFilmListCallBack
import com.xrseventy.listfilm.data.repository.FilmsListRepository
import com.xrseventy.listfilm.data.model.MovieItem
import com.xrseventy.listfilm.presentation.FilmListFragmentScreenState

//ViewModel не должны ничего знать о фрагментах
//MVVM, we don’t use interfaces for communicating to View and ViewModel

class FilmListViewModel : ViewModel() {

    private val filmsListRepository: FilmsListRepository = FilmsListRepository()
    private var _movieList: MutableLiveData<List<MovieItem>> = MutableLiveData()
   var movieList: LiveData<List<MovieItem>> = _movieList


    private var screenState: FilmListFragmentScreenState = FilmListFragmentScreenState(
            showProgressBar = false,
            showErrorMessage = false,
            itemClicked = false)


//    fun loadMovieList() {
//        movieList = filmsListRepository.getListOfPopularMovies()
//    }

//    fun getRecyclerMovieListDataObserver(): LiveData<List<MovieItem>> {
//        return _movieList
//    }

    fun loadMovieList() {
        updateScreenState(showProgressBar = true)
         // movieList = filmsListRepository.getListOfPopularMovies()

        filmsListRepository.fetchMovieListFromResponseTask(object : LoadFilmListCallBack {
            override fun onSuccess(listMovieItem:List<MovieItem>) {
                _movieList.value = listMovieItem
            }

            override fun onError() {
                TODO("Not yet implemented")
            }

        })
    }


    private fun updateScreenState(
            showProgressBar: Boolean = screenState.showProgressBar,
            showErrorMessage: Boolean = screenState.showErrorMessage,
            itemClicked: Boolean = screenState.itemClicked
    ) {
        screenState = FilmListFragmentScreenState(
                showProgressBar,
                showErrorMessage,
                itemClicked
        )
    }

    // private val configurationSet: MutableLiveData<List<String>> = filmsListRepository.getConfigurationOFilmList()
    // private val genresList: LiveData<List<GenresItem>> = filmsListRepository.getListGenres()

}

