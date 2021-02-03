package com.xrseventy.listfilm.presentation.filmLIstFragment

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.xrseventy.listfilm.R
//TODO
// Whats work: Here I get MovieID for another api request to the MovieDB
// need implement: 1.View Model
// New request
// GET /movie/{movie_id}
//https://api.themoviedb.org/3/movie/3425?api_key=923bb540f8268da1eb90ceff700bfe02&language=en-US
class DetailedFilmFragment() : Fragment() {
    private lateinit var buttonBack: Button
     var movieID: Int = 0
    companion object {
        fun newInstance() = DetailedFilmFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            movieID = requireArguments().getInt("movieID")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detailed_film_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
      //  viewModel = ViewModelProvider(this).get(DetailedFilmViewModel::class.java)
        // TODO: Use the ViewModel

        val toast =
            Toast.makeText(activity, "Second Fragment", Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0, 170)
        toast.show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonBack).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailedFilmFragment_to_filmListFragment)
        )

        view.findViewById<TextView>(R.id.textViewDetailedFilmOverview).text = movieID.toString()
        Log.d(this.toString(), "log ID $movieID")
    }
}