package com.xrseventy.listfilm.ui.recyclerView

import android.view.View
import com.xrseventy.listfilm.data.model.MovieItem

interface FilmlistClickListener {
    fun onItemClick( movieItem: MovieItem)
}