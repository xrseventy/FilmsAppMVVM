package com.my.weather.ui.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.my.weather.R

class FutureListWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = FutureListWeatherFragment()
    }

    private lateinit var viewModel: FutureListWeatherViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FutureListWeatherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}