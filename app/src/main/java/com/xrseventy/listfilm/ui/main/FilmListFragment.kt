package com.xrseventy.listfilm.ui.main

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.data.model.MovieItem
import com.xrseventy.listfilm.ui.recyclerView.FilmlistClickListener


//data class film(val title :String, val id: Int, val rating : Double)

class FilmsListFragment : Fragment(), FilmlistClickListener {

    private lateinit var viewModel: FilmListViewModel
    private lateinit var recyclerViewFilmList: RecyclerView
    private val filmlistClickListener : FilmlistClickListener


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
        recyclerViewFilmList = view.findViewById(R.id.recyclerViewFilmList)
        Log.d(this.toString(), "log onViewCreated")

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setScrollListenerOnFilmList()
    }

    private fun updateAdapter(movieList: List<MovieItem>) {
        recyclerViewFilmList.adapter = FilmsListAdapter(movieList, filmlistClickListener)

    }

    override fun onResume() {
        super.onResume()
    }



    private fun setScrollListenerOnFilmList(){
        recyclerViewFilmList.addOnScrollListener(object : RecyclerView.OnScrollListener() {

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

    override fun onItemClick(movieItem: MovieItem) {
        val toast = Toast.makeText(activity, "You are clicked on ${movieItem.title}", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 170)
        toast.show()
    }
    private fun showProgressBar(switcher: Boolean){
        val progressBar: ProgressBar = view!!.findViewById(R.id.progressBar)

        if (switcher) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }

    }

}

