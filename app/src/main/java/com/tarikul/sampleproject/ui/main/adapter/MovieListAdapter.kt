package com.tarikul.sampleproject.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.api.BaseUrl.BASE_IMAGES_URL
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.*
import com.tarikul.sampleproject.data.model.movies.Result as Result

/**
 *Created by tarikul on 29/9/20
 */
class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    private var data: List<Result> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) =
        holder.bind(data[position])

    fun swapData(data: List<Result>) {
        this.data = data
        notifyDataSetChanged()
    }

    class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Result) = with(itemView) {
            itemView.apply {
                Glide.with(ivMovieImage)
                    .load("${BASE_IMAGES_URL}${item.poster_path}")
                    .apply { RoundedCorners(20) }
                    .into(ivMovieImage)
                tvMovieTitle.text = item.original_title
                tvMovieYear.text = item.release_date.split("-")[0]
            }
            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}