import com.xrseventy.listfilm.data.model.MovieItem

interface FilmListClickListener {
    fun onItemClick( movieItem: MovieItem)
}