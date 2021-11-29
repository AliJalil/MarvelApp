package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class DataContainer(
    @SerializedName("count")
    var count: Int?,
    @SerializedName("limit")
    var limit: Int?,
    @SerializedName("offset")
    var offset: Int?,
    @SerializedName("results")
    var results: List<Any>?,
    @SerializedName("total")
    var total: Int?
)