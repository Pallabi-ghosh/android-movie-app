package com.example.myapplication.sourceCode.tvShows.api


import com.example.myapplication.sourceCode.tvShows.datamodel.GetTvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TvApi {
    @GET("tv/popular")
    fun getPopularTvShows(
        @Query("api_key") apiKey: String = com.example.myapplication.BuildConfig.apikey,
        @Query("page") page: Int
    ): Call<GetTvResponse>
}