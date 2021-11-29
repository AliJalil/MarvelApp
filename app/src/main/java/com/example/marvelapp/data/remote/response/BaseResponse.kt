package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("attributionHTML")
    var attributionHTML: String?,
    @SerializedName("attributionText")
    var attributionText: String?,
    @SerializedName("code")
    var code: Int?,
    @SerializedName("copyright")
    var copyright: String?,
    @SerializedName("etag")
    var etag: String?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("data")
    val data: List<T>?,

)