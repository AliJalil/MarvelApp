package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class DataContainer<T>(
    @SerializedName("count")
    var count: Int?,
    @SerializedName("limit")
    var limit: Int?,
    @SerializedName("offset")
    var offset: Int?,
    @SerializedName("results")
    var items: List<T>?,
    @SerializedName("total")
    var total: Int?
)