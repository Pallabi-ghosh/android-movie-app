package com.example.myapplication.data.tvShows.datamodel

import com.google.gson.annotations.SerializedName

class TvShows(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("vote_average") val rating: Float
)