package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("available")
    var available: Int? = null,
    @SerializedName("collectionURI")
    var collectionURI: String? = null,
    @SerializedName("items")
    var items: List<Item>? = null,
    @SerializedName("returned")
    var returned: Int? = null
)