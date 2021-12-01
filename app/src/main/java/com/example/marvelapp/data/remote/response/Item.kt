package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("resourceURI")
    var resourceURI: String? = null,
    @SerializedName("type")
    var type: String? = null
)