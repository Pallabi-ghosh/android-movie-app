package com.example.myapplication.sourceCode.trending

import com.example.myapplication.sourceCode.trending.datamodel.GetTrendingShowsResponse
import com.example.myapplication.sourceCode.trending.api.TrendingApi
import com.example.myapplication.sourceCode.trending.datamodel.Trending
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TrendingRepository {
    private val trendingApi: TrendingApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        trendingApi = retrofit.create(TrendingApi::class.java)
    }
    fun getTrendingShows(
        page: Int = 1,
        onSuccess: (trending: List<Trending>) -> Unit,
        onError: () -> Unit
    ){
        trendingApi.getTrendingShows(page = page)
            .enqueue(object : Callback<GetTrendingShowsResponse> {
                override fun onResponse(
                    call: Call<GetTrendingShowsResponse>,
                    response: Response<GetTrendingShowsResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.trending)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetTrendingShowsResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}