package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.movirepository.MoviesRepository
import com.example.myapplication.data.tv.TvAdapter
import com.example.myapplication.data.tv.TvShows
import com.example.myapplication.data.tvrepository.TvRepository
import com.example.myapplication.data.tvrepository.TvRepository.getPopularTvShows
import com.example.myapplication.movie.Movie
import com.example.myapplication.movie.MoviesAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter
    private lateinit var popularMoviesLayoutMgr: LinearLayoutManager

    private var popularMoviesPage = 1

    private lateinit var popularTvShows: RecyclerView
    private lateinit var popularTvAdapter: TvAdapter
    private lateinit var popularTvLayoutMgr: LinearLayoutManager

    private var popularTvPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        popularMovies = findViewById(R.id.popular_movies)
        popularMoviesLayoutMgr = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        popularMovies.layoutManager = popularMoviesLayoutMgr
        popularMoviesAdapter = MoviesAdapter(mutableListOf())
        popularMovies.adapter = popularMoviesAdapter

        getPopularMovies()

        MoviesRepository.getPopularMovies(
            popularMoviesPage,
            ::onPopularMoviesFetched,
            ::onError
        )
        popularTvShows = findViewById(R.id.popular_tv_shows)
        popularTvLayoutMgr = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        popularTvShows.layoutManager = popularTvLayoutMgr
        popularTvAdapter = TvAdapter(mutableListOf())
        popularTvShows.adapter = popularTvAdapter

        getPopularTvShows()

        TvRepository.getPopularTvShows(
            popularTvPage,
            ::onPopularTvShowsFetched,
            ::onError
        )
    }



    private fun getPopularMovies() {
        MoviesRepository.getPopularMovies(
            popularMoviesPage,
            ::onPopularMoviesFetched,
            ::onError
        )
    }

    private fun getPopularTvShows() {
        TvRepository.getPopularTvShows(
            popularTvPage,
            ::onPopularTvShowsFetched,
            ::onError
        )
    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        popularMoviesAdapter.appendMovies(movies)
        attachPopularMoviesOnScrollListener()
    }

    private fun onPopularTvShowsFetched(tvshows: List<TvShows>) {
        popularTvAdapter.appendTv(tvshows)
        attachPopularMoviesOnScrollListener()
    }


    private fun attachPopularMoviesOnScrollListener() {
        popularMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = popularMoviesLayoutMgr.itemCount
                val visibleItemCount = popularMoviesLayoutMgr.childCount
                val firstVisibleItem = popularMoviesLayoutMgr.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    popularMovies.removeOnScrollListener(this)
                    popularMoviesPage++
                    getPopularMovies()
                }
            }
        })
    }

    private fun onError() {
        Toast.makeText(this, getString(R.string.error_fetch_movies), Toast.LENGTH_SHORT).show()
    }

}



