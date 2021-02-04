package com.xrseventy.listfilm.presentation.filmLIstFragment

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.xrseventy.listfilm.App
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.data.model.DetailedMovie
import com.xrseventy.listfilm.presentation.viewModel.DetailedFilmViewModel
import com.xrseventy.listfilm.presentation.viewModel.FilmListViewModel

//TODO
// Whats work: Here I get MovieID for another api request to the MovieDB
// need implement: 1.View Model
// New request
// GET /movie/{movie_id}
//https://api.themoviedb.org/3/movie/3425?api_key=923bb540f8268da1eb90ceff700bfe02&language=en-US
class DetailedFilmFragment : Fragment() {

    private lateinit var app: App
    private lateinit var buttonBack: Button
    private lateinit var imageViewDetailed: ImageView
    private lateinit var textViewTitleMovie: TextView
    private lateinit var textViewOverviewMovie: TextView
    private lateinit var viewModel: DetailedFilmViewModel
    var movieID: Int = 0

    companion object {
        fun newInstance() = DetailedFilmFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieID = requireArguments().getInt("movieID")
        app = requireContext().applicationContext as App
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detailed_film_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonBack = view.findViewById(R.id.buttonBack)
        imageViewDetailed = view.findViewById(R.id.imageViewDetailedList)
        textViewTitleMovie = view.findViewById(R.id.textViewTitleDetailedFilm)
        textViewOverviewMovie = view.findViewById(R.id.textViewDetailedFilmOverview)
        initViewModel()
        setClickListenerOnBackButton()
        setDetailedMovie()
        Log.d(this.toString(), "log ID $movieID")



        val toast =
            Toast.makeText(activity, "Second Fragment", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 170)
        toast.show()
    }
    private fun initViewModel(){
        //viewModel = ViewModelProvider(this).get(DetailedFilmViewModel::class.java)
        viewModel = app.appContainer.getFilmListViewModel(this)
    }

    private fun setClickListenerOnBackButton(){
        buttonBack.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailedFilmFragment_to_filmListFragment)
        )
    }

    private fun setDetailedMovie(){
        viewModel.loadDetailedMovie(movieID)
        viewModel.detailedMovie.observe(viewLifecycleOwner) {
            if (it != null) {
               setMovieDetails(it)
            } else {
                Log.d(this.toString(), "Error loading list")
            }
        }
    }

    private fun setMovieDetails(movie: DetailedMovie){
        textViewTitleMovie.text = movie.title
        textViewOverviewMovie.text = movie.overview
    }
}