package com.xrseventy.listfilm.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.listFilms.data.repository.remote_data_source.NetworkModule
import com.my.listFilms.data.repository.remote_data_source.NetworkModule.API_KEY
import com.xrseventy.listfilm.data.repository.model.MovieDetails
import com.xrseventy.listfilm.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

data class film(val title :String, val id: Int, val rating : Double)

class FilmsListFragment : Fragment() {

    //private var layoutManager: RecyclerView.LayoutManager? = null
    // private var adapter: RecyclerView.Adapter<FilmListViewHolder>? = null
    //private var recyclerViewFilmList = view?.findViewById<RecyclerView>(R.id.recyclerViewFilmList)


    private val theMovieDbApiService = NetworkModule.theMovieDbApiService
    private val movieDetailsList = listOf<MovieDetails>()

    //private lateinit var viewModel: FilmListViewModel

//    private val viewModel: FilmListViewModel by lazy {
//        ViewModelProvider(this).get(FilmListViewModel::class.java)
//    }
    private val film = listOf(
            film("Raising Arizona", 1987, 1.2),
            film("Vampire's Kiss", 1988, 1.2),
            film("Con Air", 1997, 1.2),
            film("Gone in 60 Seconds", 1997, 1.2),
            film("National Treasure", 2004, 1.2),
            film("The Wicker Man", 2006, 1.2),
            film("Ghost Rider", 2007, 1.2),
            film("Knowing", 2009, 1.2)
    )

//    private val MovieDetailsList = listOf<MovieDetails>(
//    MovieDetails(1, 1, "qwe", 1.2, "poster", "12.02", 1, 1,"1",
//    "", "", true, 1.2)
//   )


    companion object {
        fun newInstance() = FilmsListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        Log.d(this.toString(), "log onCreate")

      //  val moviId: Int = requireArguments().getInt(MOVIE_KEY)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(this.toString(), "log onCreateView")
        return inflater.inflate(R.layout.film_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(this.toString(), "log onViewCreated")
        val recyclerViewFilmList: RecyclerView = view.findViewById(R.id.recyclerViewFilmList)

        recyclerViewFilmList?.adapter = FilmsListAdapter(film)
        recyclerViewFilmList.layoutManager = LinearLayoutManager(view.context
        ,LinearLayoutManager.VERTICAL, false )

//        recyclerViewFilmList?.apply {
//            layoutManager = LinearLayoutManager(activity)
//            //adapter = FilmsListAdapter(film)
//            adapter = FilmsListAdapter(movieList)
//            //Log.d(this.toString(), "MovieDetailsList = $MovieDetailsList")
//
//        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(FilmListViewModel::class.java)
        // TODO: Use the ViewModel

        Log.d(this.toString(), "log onActivityCreated")
    }


    override fun onResume() {
        super.onResume()

        val movieCall: Call<List<MovieDetails>> = theMovieDbApiService.getMovieDetails()
        Log.d(this.toString(), "log onResume")
        movieCall.enqueue(object : Callback<List<MovieDetails>> {
            override fun onFailure(call: Call<List<MovieDetails>>, t: Throwable) {
                val toastAdd = Toast.makeText(activity, "2", Toast.LENGTH_LONG)
                toastAdd.setGravity(Gravity.TOP, 0, 170)
                toastAdd.show()


            }
            override fun onResponse(
                call: Call<List<MovieDetails>>,
                response: Response<List<MovieDetails>>

            ) {
                val movieList: List<MovieDetails> = response.body() ?: emptyList()
                val url =  response.raw().request().url()
                Log.d(this.toString(), "log onResponse $movieList")
                Log.d(this.toString(), "URL = $url")

                val toastAdd = Toast.makeText(activity, "3", Toast.LENGTH_LONG)
                toastAdd.setGravity(Gravity.TOP, 0, 170)
                toastAdd.show()

            }
        })

    }

}

