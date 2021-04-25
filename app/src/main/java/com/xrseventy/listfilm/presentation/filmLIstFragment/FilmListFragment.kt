package com.xrseventy.listfilm.presentation.filmLIstFragment

import FilmListClickListener
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xrseventy.listfilm.App
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.data.model.MovieItem
import com.xrseventy.listfilm.presentation.FilmListFragmentScreenState
import com.xrseventy.listfilm.presentation.filmListRecyclerView.FilmListAdapter
import com.xrseventy.listfilm.presentation.viewModels.FilmListViewModel

class FilmListFragment : Fragment(R.layout.film_list_fragment), FilmListClickListener {

    private lateinit var viewModel: FilmListViewModel
    private var recyclerViewFilmList: RecyclerView? = null
    private lateinit var app: App
    private lateinit var navController: NavController


    override fun onAttach(context: Context) {
        super.onAttach(context)
        app = requireContext().applicationContext as App
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        initViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewFilmList = view.findViewById(R.id.recyclerViewFilmList)
        (activity as AppCompatActivity).supportActionBar?.show()
        showProgressBar(true)
        initAdapter()
        initBtnRetry()
        checkOrientationForFilmList(view)
        loadListFilm()
        showProgressBar(false)
        navController = Navigation.findNavController(view)
        //renderView(screenState)
    }

    fun initBtnRetry() {

    }


    private fun checkOrientationForFilmList(view: View) {
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerViewFilmList?.layoutManager = GridLayoutManager(view.context, 2)
        } else {
            recyclerViewFilmList?.layoutManager =
                LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        }
    }

    private fun initViewModel() {
        viewModel = app.appContainer.getFilmListViewModel(this)

    }

    private fun loadListFilm() {
        viewModel.loadMovieList()
        viewModel.movieList.observe(viewLifecycleOwner) {
            updateAdapter(it)
        }
    }

    private fun initAdapter() {
        val list: List<MovieItem> = emptyList()
        updateAdapter(list)

    }

    private fun updateAdapter(movieList: List<MovieItem>) {
        recyclerViewFilmList?.adapter = FilmListAdapter(movieList, this)
    }

    override fun onItemClick(movieItem: MovieItem) {
        val bundle = bundleOf("movieID" to movieItem.id)
        if (navController.currentDestination?.id == R.id.filmListFragment) {
            navController.navigate(R.id.action_filmListFragment_to_detailedFilmFragment, bundle)
        }
    }

//TODO maybe will need for loading next pages

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setScrollListenerOnFilmList()
    }

    private fun setScrollListenerOnFilmList() {
        recyclerViewFilmList?.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    val toast = Toast.makeText(activity, "LAST", Toast.LENGTH_LONG)
                    toast.setGravity(Gravity.TOP, 0, 170)
                    toast.show()

                    showProgressBar(true)
                } else
                    showProgressBar(false)
            }
        })
    }

    private fun showProgressBar(switcher: Boolean) {
        val progressBar: ProgressBar = requireView().findViewById(R.id.progressBar)

        if (switcher) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}