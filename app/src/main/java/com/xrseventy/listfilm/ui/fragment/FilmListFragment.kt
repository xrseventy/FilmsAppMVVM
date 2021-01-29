package com.xrseventy.listfilm.ui.fragment

import FilmListClickListener
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.data.model.MovieItem
import com.xrseventy.listfilm.ui.recyclerView.FilmsListAdapter

class FilmsListFragment : Fragment(), FilmListClickListener {

    private lateinit var viewModel: FilmListViewModel
    private lateinit var recyclerViewFilmList: RecyclerView

    companion object {
        fun newInstance() = FilmsListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        initViewModel()
        return inflater.inflate(R.layout.film_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewFilmList = view.findViewById(R.id.recyclerViewFilmList)
        checkOrientationForFilmList(view)

    }

    private fun checkOrientationForFilmList(view: View) {
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerViewFilmList.layoutManager = GridLayoutManager(view.context, 2)
        } else {
            recyclerViewFilmList.layoutManager =
                LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(FilmListViewModel::class.java)
        viewModel.getRecyclerMovieListDataObserver().observe(this) {
            if (it != null) {
                updateAdapter(it) //TODO logic go off
            } else {
                Log.d(this.toString(), "Error loading list")
            }
        }
    }

    private fun updateAdapter(movieList: List<MovieItem>) {
        recyclerViewFilmList.adapter = FilmsListAdapter(movieList, this)

    }

    override fun onItemClick(movieItem: MovieItem) {
        val toast =
            Toast.makeText(activity, "You are clicked on ${movieItem.title}", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 170)
        toast.show()
    }
}


//TODO maybe will need for loading next pages

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        //setScrollListenerOnFilmList()
//    }

//    private fun setScrollListenerOnFilmList(){
//        recyclerViewFilmList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (!recyclerView.canScrollVertically(1)) {
//                    val toast = Toast.makeText(activity, "LAST", Toast.LENGTH_LONG)
//                    toast.setGravity(Gravity.TOP, 0, 170)
//                    toast.show()
//
//                    showProgressBar(true)
//                } else
//                    showProgressBar(false)
//
//            }
//        })
//    }

//    private fun showProgressBar(switcher: Boolean){
//        val progressBar: ProgressBar = view!!.findViewById(R.id.progressBar)
//
//        if (switcher) {
//            progressBar.visibility = View.VISIBLE
//        } else {
//            progressBar.visibility = View.GONE
//        }
//
//    }


