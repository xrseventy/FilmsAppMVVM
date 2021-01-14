package com.my.filmsMVVM.ui.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my.weather.R

class FilmsListFragment : Fragment() {

    companion object {
        fun newInstance() = FilmsListFragment()
    }

    private lateinit var viewModel: FilmsListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.films_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilmsListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    }


}