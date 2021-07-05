package com.example.myapplication.data.api

import com.example.myapplication.data.GetTrendingShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingApi {
    @GET("trending/all/day")
    abstract fun getTrendingShows(
        @Query("api_key") apiKey: String = "5e575735f7b8c4d22dd904565060e017",
        @Query("page") page: Int
    ): Call<GetTrendingShowsResponse>
}