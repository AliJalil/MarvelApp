package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class DataContainer<T>(
    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("limit")
    var limit: Int? = null,
    @SerializedName("offset")
    var offset: Int? = null,
    @SerializedName("results")
    var results: List<T>? = null,
    @SerializedName("total")
    var total: Int? = null
)