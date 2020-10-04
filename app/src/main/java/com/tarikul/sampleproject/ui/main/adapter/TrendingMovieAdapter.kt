package com.tarikul.sampleproject.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.api.BaseUrl.BASE_IMAGES_URL
import com.tarikul.sampleproject.data.model.trendingList.Result
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.*


/**
 *Created by tarikul on 29/9/20
 */
class TrendingMovieAdapter : RecyclerView.Adapter<TrendingMovieAdapter.MovieListViewHolder>() {

    private var data: List<Result> = ArrayList()
    private val TAG = "TrendingMovieAdapter"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        Log.e(TAG, "onCreateViewHolder: ")
        return MovieListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_trending, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        Log.e(TAG, "onBindViewHolder: ")
        return holder.bind(data[position])
    }

    fun swapData(data: List<Result>) {
        this.data = data
        Log.e(TAG, "swapData: " + data.size)
        notifyDataSetChanged()
    }

    class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val TAG = "TrendingMovieAdapter"
        fun bind(item: Result) = with(itemView) {
            Log.e(TAG, "bind: ")
            itemView.apply {
                var requestOptions = RequestOptions()
                requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(10))
                tvMovieTitle.text = item.original_title
                tvRating.text = item.vote_average.toString()
                Glide.with(ivMovieImage)
                    .load("${BASE_IMAGES_URL}${item.poster_path}")
                    .apply(requestOptions)
                    .into(ivMovieImage)

            }
            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}