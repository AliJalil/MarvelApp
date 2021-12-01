package com.example.marvelapp.data.remote.response


import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("comics")
    var comics: Comics? = null,
    @SerializedName("description")
    var description: String?= null,
    @SerializedName("events")
    var events: Events?= null,
    @SerializedName("id")
    var id: Int?= null,
    @SerializedName("modified")
    var modified: String?= null,
    @SerializedName("name")
    var name: String?= null,
    @SerializedName("resourceURI")
    var resourceURI: String?= null,
    @SerializedName("series")
    var series: Series?= null,
    @SerializedName("stories")
    var stories: Stories?= null,
    @SerializedName("thumbnail")
    var thumbnail: Thumbnail?= null,
    @SerializedName("urls")
    var urls: List<Url>? = null
)