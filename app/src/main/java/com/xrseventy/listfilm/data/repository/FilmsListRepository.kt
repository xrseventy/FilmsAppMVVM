package com.xrseventy.listfilm.data.repository

import com.my.listFilms.data.repository.remote_data_source.NetworkModule
import com.xrseventy.listfilm.data.network.LoadFilmListCallBack
import com.xrseventy.listfilm.data.model.MovieItem
import com.xrseventy.listfilm.data.model.PopularMoviesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsListRepository(private val networkModule: NetworkModule) {

    fun makeApiCallGetListPopularMovies(callback: LoadFilmListCallBack) {

        var popularMovieList: PopularMoviesList
        val popularMovieCall: Call<PopularMoviesList> = networkModule.theMovieDbApiService.getMoviePopular()

        popularMovieCall.enqueue(object : Callback<PopularMoviesList> {

            override fun onFailure(call: Call<PopularMoviesList>, t: Throwable) {
                callback.onError()
            }

            override fun onResponse(
                    call: Call<PopularMoviesList>,
                    response: Response<PopularMoviesList>
            ) {
                if (response.isSuccessful) {
                    popularMovieList = response.body()!!
                    callback.onSuccess(popularMovieList.results)
                } else {
                    callback.onError()
                }
            }
        })
    }

    fun fetchMovieListFromResponseTask(callBack: LoadFilmListCallBack) {

        makeApiCallGetListPopularMovies(object : LoadFilmListCallBack {

            override fun onSuccess(listMovieItem: List<MovieItem>) {
                callBack.onSuccess(listMovieItem)
            }

            override fun onError() {
                callBack.onError()
            }
        })
    }


//TODO work without callbacks

//    fun getListOfPopularMovies(): MutableLiveData<List<MovieItem>> {
//        val popularList = makeApiCallGetListPopularMovies()
//        // getListGenres()
//        return popularList.map { PopularMoviesList -> PopularMoviesList.results } as MutableLiveData<List<MovieItem>>
//    }

}

//private fun getGenreApiCall(callback: LoadGenresCallBack): GenresList {
//    val movieGenres = GenresList()
//    val movieGenre: Call<GenresList> = theMovieDbApiService.getGenre(
//            NetworkModule.API_KEY,
//            (Locale.getDefault().language.toString())
//    )
//    movieGenre.enqueue(object : Callback<GenresList> {
//
//        override fun onFailure(call: Call<GenresList>, t: Throwable) {
//            movieGenres.value = null
//        }
//
//        override fun onResponse(
//                call: Call<GenresList>,
//                response: Response<GenresList>
//
//        ) {
//            // val movieGenres: GenresList? = response.body()
//            movieGenres.value = response.body()
//            val url = response.raw().request().url()
//            Log.d(this.toString(), "log movieGenres $movieGenres")
//            Log.d(this.toString(), "log genreUrl = $url")
//        }
//    })
//    //https://api.themoviedb.org/3/genre/movie/list?api_key=923bb540f8268da1eb90ceff700bfe02&language=en-US
//
//}


//fun getListGenres(): LiveData<List<GenresItem>> {
//
//    val loadMovieGenres: LiveData<GenresList> = getGenreApiCall()
//    val movieGenresItem: LiveData<List<GenresItem>> =
//            loadMovieGenres.map { GenresList -> GenresList.genres }
//
//    Log.d(this.toString(), "log genres = $movieGenresItem")
//
//    return movieGenresItem
//
//}

//TODO for config
//private fun getConfigurationApiCall() : Configuration{
//        Log.d(this.toString(), "log 2")
//
//        val configurationTheMovieDb = MutableLiveData<Configuration>()
//
//        val configurationCall: Call<Configuration> =
//            NetworkModule.theMovieDbApiService.getConfiguration(NetworkModule.API_KEY
//            )
//
//        configurationCall.enqueue(object : Callback<Configuration> {
//
//            override fun onFailure(call: Call<Configuration>, t: Throwable) {
//                configurationTheMovieDb.postValue(null)
//                Log.d(this.toString(), "log 3")
//            }
//
//            override fun onResponse(
//                call: Call<Configuration>,
//                response: Response<Configuration>
//
//            ) {
//                Log.d(this.toString(), "log 4")
//                configurationTheMovieDb.value = response.body()
//                val url = response.raw().request().url()
//                Log.d(this.toString(), "log url = $url")
//
//            }
//        })
//        return configurationTheMovieDb
//
//    }
//
//
//
//    fun getConfigurationOfImages() : String {
//        Log.d(this.toString(), "log 1")
//        val configurationTheMovieDb = getConfigurationApiCall()
//        conf
//        return configurationTheMovieDb.map { Configuration ->  Configuration.images.baseUrl.toString()}
//
//    }