package com.xrseventy.listfilm.data.repository.model


import com.google.gson.annotations.SerializedName

data class Configuration(
    @SerializedName("change_keys")
    val changeKeys: List<String>,
    val images: Images
)