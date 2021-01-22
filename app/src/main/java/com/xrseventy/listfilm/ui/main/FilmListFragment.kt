package com.xrseventy.listfilm.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.listFilms.data.repository.remote_data_source.NetworkModule

import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.data.repository.FilmsListRepository

import com.xrseventy.listfilm.data.repository.model.Configuration
import com.xrseventy.listfilm.data.repository.model.MovieItem
import com.xrseventy.listfilm.data.repository.model.PopularMoviesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//data class film(val title :String, val id: Int, val rating : Double)

class FilmsListFragment : Fragment() {

    private lateinit var viewModel: FilmListViewModel

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

    companion object {
        fun newInstance() = FilmsListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        Log.d(this.toString(), "log onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(this.toString(), "log onCreateView")


        viewModel = ViewModelProvider(this).get(FilmListViewModel::class.java)
        viewModel.getRecyclerMovieListDataObserver().observe(this, Observer<List<MovieItem>> {
            if (it != null) {
                updateAdapter(it)
            } else {
                val toast = Toast.makeText(activity, "ERROR", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.TOP, 0, 170)
                toast.show()
            }
        })

        return inflater.inflate(R.layout.film_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(this.toString(), "log onViewCreated")

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun updateAdapter(movieList: List<MovieItem>) {

        val recyclerViewFilmList: RecyclerView = view!!.findViewById(R.id.recyclerViewFilmList)         //TODO del !!
        recyclerViewFilmList.adapter = FilmsListAdapter(movieList)

    }

    override fun onResume() {
        super.onResume()
    }

}

