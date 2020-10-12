package com.tarikul.sampleproject.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.api.BaseUrl.BASE_IMAGES_URL
import com.tarikul.sampleproject.data.model.movieList.Result
import com.tarikul.sampleproject.ui.main.view.fragment.HomeFragmentDirections
import com.tos.androidlivedataviewmodel.projectOne.utils.MovieType
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.*


/**
 *Created by tarikul on 29/9/20
 */
class MoviePagingAdapter : RecyclerView.Adapter<MoviePagingAdapter.MovieListViewHolder>() {

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
                var requestOptions = RequestOptions()
                requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(10))
                tvMovieTitle.text = item.original_title
                tvRating.text = item.vote_average.toString()
                tvMovieYear.text = item.release_date.split("-")[0]
                Glide.with(ivMovieImage)
                    .load("${BASE_IMAGES_URL}${item.poster_path}")
                    .apply(requestOptions)
                    .into(ivMovieImage)

            }
            setOnClickListener {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(item.id.toString())
                findNavController().navigate(action)
            }
        }
    }

    companion object {
        private val diffUtilCallback = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }

}