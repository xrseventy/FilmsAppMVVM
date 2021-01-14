package com.my.filmsMVVM.ui.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.my.filmsMVVM.data.response.MovieDetails

class FilmsListViewModel : ViewModel() {
    lateinit var filmsListLiveData: MutableLiveData<RecyclerList>

    val movieId : Int = TODO()
    val movie : MovieDetails = TODO()
    //ViewModel might involve directly calling the
    // Webservice to fetch the data and assign
    // this data to our LiveData object.

    //Every time the user profile data is updated, the onChanged() callback is invoked, and the UI is refreshed.
}