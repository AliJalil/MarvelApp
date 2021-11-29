package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class CharecterDto(
    @SerializedName("comics")
    var comics: Comics? = null,
    @SerializedName("description")
    var description: String?,
    @SerializedName("events")
    var events: Events?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("modified")
    var modified: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("resourceURI")
    var resourceURI: String?,
    @SerializedName("series")
    var series: Series?,
    @SerializedName("stories")
    var stories: Stories?,
    @SerializedName("thumbnail")
    var thumbnail: Thumbnail?,
    @SerializedName("urls")
    var urls: List<Url>?
)