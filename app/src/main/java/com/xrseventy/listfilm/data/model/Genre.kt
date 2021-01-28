package com.xrseventy.listfilm.data.model
import com.google.gson.annotations.SerializedName

data class GenresList(

    @SerializedName("genres")
    val genres: List<GenresItem>
)

data class GenresItem(

    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int
)