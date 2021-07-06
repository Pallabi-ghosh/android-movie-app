package com.example.myapplication.data.tvShows.datamodel

import com.google.gson.annotations.SerializedName

class GetTvResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val tv: List<TvShows>,
    @SerializedName("total_pages") val pages: Int
)