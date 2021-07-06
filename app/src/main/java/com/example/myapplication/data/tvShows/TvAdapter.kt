package com.example.myapplication.data.tvShows

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.tvShows.datamodel.TvShows


class TvAdapter (
    private var tvshows: MutableList<TvShows>
) : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_tv, parent, false)
        return TvViewHolder(view)
    }

    override fun getItemCount(): Int = tvshows.size

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.bind(tvshows[position])
    }

    fun appendTv(tvshows: List<TvShows>) {
        this.tvshows.addAll(tvshows)
        notifyItemRangeInserted(
            this.tvshows.size,
            tvshows.size - 1
        )
    }

    inner class TvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val poster: ImageView = itemView.findViewById(R.id.item_tv_poster)

        fun bind(tvshows: TvShows) {
            Log.i("Poster", "I am here")
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${tvshows.posterPath}")
                .into(poster)
        }
    }
}