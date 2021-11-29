package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    var extension: String?,
    @SerializedName("path")
    var path: String?
)