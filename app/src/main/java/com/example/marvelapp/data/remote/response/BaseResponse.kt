package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("attributionHTML")
    var attributionHTML: String? = null,
    @SerializedName("attributionText")
    var attributionText: String? = null,
    @SerializedName("code")
    var code: Int? = null,
    @SerializedName("copyright")
    var copyright: String? = null,
    @SerializedName("etag")
    var etag: String? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("data")
    val items: DataContainer<T>? = null,

)