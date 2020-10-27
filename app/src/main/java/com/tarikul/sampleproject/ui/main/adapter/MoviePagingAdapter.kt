package com.tarikul.sampleproject.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.api.BaseUrl.BASE_IMAGES_URL
import com.tarikul.sampleproject.data.model.movieList.Result
import com.tarikul.sampleproject.ui.main.home.HomeFragmentDirections
import com.tarikul.sampleproject.ui.main.pagination.PaginationState
import kotlinx.android.synthetic.main.item_movie.view.*
import kotlinx.android.synthetic.main.loading_view_layout.view.*
import java.util.*


/**
 *Created by tarikul on 29/9/20
 */
class MoviePagingAdapter(private val listener: movieInteractionListener) :
    PagedListAdapter<Result, RecyclerView.ViewHolder>(diffUtilCallback) {

    private var state: PaginationState? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.item_movie -> MovieListViewHolder(view)
            R.layout.loading_view_layout -> LoadingViewHolder(view)
            else -> throw IllegalArgumentException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.item_movie -> getItem(position)?.let {
                (holder as MovieListViewHolder).bind(
                    it,
                    listener
                )
            }
            R.layout.loading_view_layout -> (holder as LoadingViewHolder).bind(state, listener)
        }
    }


    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasFooter()) 1 else 0
    }

    private fun hasFooter(): Boolean {
        return super.getItemCount() != 0 && (state == PaginationState.LOADING || state == PaginationState.ERROR)
    }

    fun updatePaginationState(newState: PaginationState) {
        this.state = newState
        if (newState != PaginationState.LOADING) {
            notifyDataSetChanged()
        }
    }

    class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Result, listener: movieInteractionListener) = with(itemView) {
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

    class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(status: PaginationState?, listener: movieInteractionListener) {
            hideViews()
            setVisibleRightViews(status)
            itemView.btn_retry.setOnClickListener { listener.onClickRetry() }
        }

        private fun hideViews() {
            itemView.tv_error_message.visibility = View.GONE
            itemView.btn_retry.visibility = View.GONE
        }

        private fun setVisibleRightViews(paginationState: PaginationState?) {
            when (paginationState) {
                PaginationState.ERROR -> {
                    itemView.btn_retry.visibility = View.VISIBLE
                    itemView.tv_error_message.visibility = View.VISIBLE
                }
            }
        }

    }

}