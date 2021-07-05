package com.example.myapplication.data

import com.example.myapplication.data.tranding.Trending
import com.google.gson.annotations.SerializedName

data class GetTrendingShowsResponse (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val trending: List<Trending>,
    @SerializedName("total_pages") val pages: Int
)