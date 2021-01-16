package com.xrseventy.listfilm.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.ui.recyclerView.FilmListViewHolder

data class film(val title :String, val id: Int, val rating : Double)

class FilmsListFragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<FilmListViewHolder>? = null
    var recyclerViewFilmList = view?.findViewById<RecyclerView>(R.id.recyclerViewFilmList)

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

    companion object {
        fun newInstance() = FilmsListFragment()
    }

    //   private lateinit var viewModel: FilmsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.film_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewFilmList = view.findViewById(R.id.recyclerViewFilmList) as RecyclerView
        recyclerViewFilmList?.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = FilmsListAdapter(film)
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(FilmListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}