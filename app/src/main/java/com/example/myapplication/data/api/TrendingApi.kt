package com.example.myapplication.data.api

import com.example.myapplication.data.GetTrendingShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingApi {
    @GET("trending/all/day")
    fun getTrendingShows(
        @Query("api_key") apiKey: String = com.example.myapplication.BuildConfig.apikey,
        @Query("page") page: Int
    ): Call<GetTrendingShowsResponse>
}