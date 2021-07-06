package com.example.myapplication.data.trending.datamodel

import com.google.gson.annotations.SerializedName

data class GetTrendingShowsResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val trending: List<Trending>,
    @SerializedName("total_pages") val pages: Int
)