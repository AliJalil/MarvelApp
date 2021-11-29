package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class ItemX(
    @SerializedName("name")
    var name: String?,
    @SerializedName("resourceURI")
    var resourceURI: String?
)