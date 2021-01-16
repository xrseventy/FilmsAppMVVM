package com.xrseventy.listfilm.data.response//package com.my.filmsMVVM.data.repository
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.my.filmsMVVM.data.repository.remote_data_source.TheMovieDbApiService
//import com.my.filmsMVVM.data.response.MovieDetails
//import io.reactivex.Scheduler
//import io.reactivex.disposables.CompositeDisposable
//import io.reactivex.schedulers.Schedulers
//
//class MovieDetailsNetworkDataSource (private val apiService: TheMovieDbApiService, val compositeDisposable: CompositeDisposable)
//{
//    private val _networkState = MutableLiveData<NetworkState>()
//    val networkState: LiveData<MovieDetailsNetworkDataSource>
//        get() = _networkState
//
//    private val _downloadedMovieDetailsResponse = MutableLiveData<MovieDetails>()
//    val downloadedMovieDetailsResponse: LiveData<MovieDetails>
//        get() = _downloadedMovieDetailsResponse
//
//    fun fetchMovieDetails(movieId: Int)
//    {
//        _networkState.postValue(NetworkState.LOADING)
//        try {
//            compositeDisposable.add(
//                apiService.getMovieDetails(movieId)
//                    .subscribeOn(Schedulers.io())
//                    .subscribe(
//                        {
//                            _downloadedMovieDetailsResponse.postValue(it)
//                        }
//                    )
//            )
//        }
//    }
//}