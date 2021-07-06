package com.example.myapplication.sourceCode.trending

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.sourceCode.trending.datamodel.Trending


class TrendingAdapter (
    private var trending: MutableList<Trending>
) : RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingAdapter.TrendingViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_tranding, parent, false)
        return TrendingViewHolder(view)
    }

    override fun getItemCount(): Int = trending.size

    override fun onBindViewHolder(holder: TrendingAdapter.TrendingViewHolder, position: Int) {
        holder.bind(trending[position])
    }

    fun appendTrending(trending: List<Trending>) {
        this.trending.addAll(trending)
        notifyItemRangeInserted(
            this.trending.size,
            trending.size - 1
        )
    }

    inner class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val poster: ImageView = itemView.findViewById(R.id.item_tranding_poster)

        fun bind(trending: Trending) {
            Log.i("Trending", "I am here")
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${trending.posterPath}")
                .into(poster)
        }
    }
}
