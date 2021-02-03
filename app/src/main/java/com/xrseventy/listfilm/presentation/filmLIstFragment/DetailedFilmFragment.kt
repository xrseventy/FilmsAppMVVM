package com.xrseventy.listfilm.presentation.filmLIstFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xrseventy.listfilm.R

class DetailedFilmFragment : Fragment() {

    companion object {
        fun newInstance() = DetailedFilmFragment()
    }

    private lateinit var viewModel: DetailedFilmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detailed_film_fragment2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailedFilmViewModel::class.java)
        // TODO: Use the ViewModel
    }

}