package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    var extension: String? = null,
    @SerializedName("path")
    var path: String? = null
)