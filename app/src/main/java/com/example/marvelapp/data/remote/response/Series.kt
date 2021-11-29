package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("available")
    var available: Int?,
    @SerializedName("collectionURI")
    var collectionURI: String?,
    @SerializedName("items")
    var items: List<ItemXX>?,
    @SerializedName("returned")
    var returned: Int?
)