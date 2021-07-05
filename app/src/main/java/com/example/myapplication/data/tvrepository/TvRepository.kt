package com.example.myapplication.data.tvrepository

import com.example.myapplication.data.GetTvResponse
import com.example.myapplication.data.api.TvApi
import com.example.myapplication.data.tv.TvShows
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TvRepository {

    private val tvApi: TvApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        tvApi = retrofit.create(TvApi::class.java)
    }
    fun getPopularTvShows(
        page: Int = 1,
        onSuccess: (tvshows: List<TvShows>) -> Unit,
        onError: () -> Unit
    ){
        TvRepository.tvApi.getPopularTvShows(page = page)
            .enqueue(object : Callback<GetTvResponse> {
                override fun onResponse(
                    call: Call<GetTvResponse>,
                    response: Response<GetTvResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.tv)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetTvResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }
}