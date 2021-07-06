package com.example.myapplication.data.movies.api

import com.example.myapplication.data.movies.datamodel.GetMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = com.example.myapplication.BuildConfig.apikey,
        @Query("page") page: Int
    ): Call<GetMoviesResponse>
}