package com.xrseventy.listfilm.presentation.filmLIstFragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.xrseventy.listfilm.App
import com.xrseventy.listfilm.R
import com.xrseventy.listfilm.data.model.DetailedMovieApi
import com.xrseventy.listfilm.data.model.Genre
import com.xrseventy.listfilm.databinding.DetailedFilmFragmentBinding
import com.xrseventy.listfilm.presentation.viewModels.DetailedFilmViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

//TODO
// Whats work: Here I get MovieID for another api request to the MovieDB
// need implement: 1.View Model
// New request
// GET /movie/{movie_id}
//https://api.themoviedb.org/3/movie/3425?api_key=923bb540f8268da1eb90ceff700bfe02&language=en-US
//https://api.themoviedb.org/movie/464052?api_key=923bb540f8268da1eb90ceff700bfe02&language=en
class DetailedFilmFragment : Fragment(R.layout.detailed_film_fragment) {

    private var viewBinding: DetailedFilmFragmentBinding? = null
    //private val viewBinding get() = _viewBinding

    private lateinit var app: App
    private lateinit var viewModel: DetailedFilmViewModel
    private var movieID: Int = 0
    private val listGenre: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieID = requireArguments().getInt("movieID")
        app = requireContext().applicationContext as App
        (activity as AppCompatActivity).supportActionBar?.hide()
//        // my_child_toolbar is defined in the layout file
//        setSupportActionBar(findViewById(R.id.my_child_toolbar))
//
//        // Get a support ActionBar corresponding to this toolbar and enable the Up button
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewBinding = DetailedFilmFragmentBinding.inflate(inflater, container, false)
        return viewBinding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        setClickListenerOnBackButton()
        setDetailedMovie()
        Log.d(this.toString(), "log ID $movieID")
    }


    private fun initViewModel() {
        viewModel = app.appContainer.getDetailedViewModel(this)
    }


    private fun setClickListenerOnBackButton() {
        viewBinding?.buttonBack?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailedFilmFragment_to_filmListFragment)
        )
    }

    private fun setDetailedMovie() {
        viewModel.loadDetailedMovie(movieID)
        viewModel.detailedMovie.observe(viewLifecycleOwner) {
            setMovieDetails(it)
            setImageViewDetailed(it.poster_path)
        }
    }

    private fun Date.getFormattedDate(simpleDateFormat: SimpleDateFormat): String =
        simpleDateFormat.format(this)

    private fun setMovieDetails(movie: DetailedMovieApi) {
        with(viewBinding ?: return) {
            with(infoIncludeDetailed ?: return) {
                textViewTitleDetailedFilm.text = movie.title
                mapGenres(movie.genres)
                textViewDetailedGenres.text = listGenre.toString()
                textViewDetailedVoteCount.text = movie.vote_count.toString()
                ratingBarDetailed.rating = movie.vote_average.toFloat() / 2
                textViewDetailedReleaseDate.text =
                    movie.release_date.getFormattedDate(SimpleDateFormat("d MMMM YYYY"))
                textViewDetailedFilmOverview.text = movie.overview
            }
        }
    }

    private fun mapGenres(genres: List<Genre>) =
        genres.map {
            getListGenres(it.name)
        }

    private fun getListGenres(genreName: String) =
        listGenre.add(genreName)

    private fun setImageViewDetailed(pathToImage: String) {
        viewBinding?.imageViewIncludeDetailed?.let {
            Glide.with(this)
                .load(POSTER_BASE_URL + pathToImage)
                .into(it.imgViewIncludeDetailed)
        }
    }

    val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500"

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    companion object {
        fun newInstance() = DetailedFilmFragment()
    }
}