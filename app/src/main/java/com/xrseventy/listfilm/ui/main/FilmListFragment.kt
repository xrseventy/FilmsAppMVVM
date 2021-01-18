package com.xrseventy.listfilm.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.listFilms.data.repository.remote_data_source.NetworkModule
import com.xrseventy.listfilm.data.repository.model.MovieDetails
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.ui.recyclerView.FilmListViewHolder
import kotlinx.coroutines.coroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//data class film(val title :String, val id: Int, val rating : Double)

class FilmsListFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<FilmListViewHolder>? = null
    var recyclerViewFilmList = view?.findViewById<RecyclerView>(R.id.recyclerViewFilmList)
    private val theMovieDbApiService = NetworkModule.theMovieDbApiService
//    private val viewModel: FilmListViewModel by lazy {
//        ViewModelProvider(this).get(FilmListViewModel::class.java)
//    }
//    private val film = listOf(
//            film("Raising Arizona", 1987, 1.2),
//            film("Vampire's Kiss", 1988, 1.2),
//            film("Con Air", 1997, 1.2),
//            film("Gone in 60 Seconds", 1997, 1.2),
//            film("National Treasure", 2004, 1.2),
//            film("The Wicker Man", 2006, 1.2),
//            film("Ghost Rider", 2007, 1.2),
//            film("Knowing", 2009, 1.2)
//    )

//    private val MovieDetailsList = listOf<MovieDetails>(
//    MovieDetails(1, 1, "qwe", 1.2, "poster", "12.02", 1, 1,"1",
//    "", "", true, 1.2)
//   )
private val MovieDetailsList = listOf<MovieDetails>()

    companion object {
        fun newInstance() = FilmsListFragment()
    }

      //private lateinit var viewModel: FilmListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.film_list_fragment, container, false)
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewFilmList = view.findViewById(R.id.recyclerViewFilmList) as RecyclerView
        recyclerViewFilmList?.apply {
            layoutManager = LinearLayoutManager(activity)
            //adapter = FilmsListAdapter(film)
            adapter = FilmsListAdapter(MovieDetailsList)
            Log.d(this.toString(), "MovieDetailsList = $MovieDetailsList")

        }

        val movieCall: Call<List<MovieDetails>> = theMovieDbApiService.getMovieDetails()

        movieCall.enqueue(object : Callback<List<MovieDetails>> {
            override fun onFailure(call: Call<List<MovieDetails>>, t: Throwable) {
                val toastAdd = Toast.makeText(activity, "Added", Toast.LENGTH_LONG)
                toastAdd.setGravity(Gravity.TOP, 0, 170)
                toastAdd.show()
            }


            override fun onResponse(
                call: Call<List<MovieDetails>>,
                response: Response<List<MovieDetails>>
            ) {
                val movieList: List<MovieDetails> = response.body() ?: emptyList()
                adapter = FilmsListAdapter(movieList)
            }
        })
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(FilmListViewModel::class.java)
        // TODO: Use the ViewModel
    }


}

