package com.tarikul.sampleproject.ui.main.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.model.movieList.Result
import com.tarikul.sampleproject.ui.base.ViewModelFactory
import com.tarikul.sampleproject.ui.main.adapter.*
import com.tarikul.sampleproject.ui.main.pagination.PaginationState
import com.tarikul.sampleproject.ui.main.viewmodel.MoviesFragmentViewModel
import com.tos.androidlivedataviewmodel.projectOne.data.api.ApiHelperImpl
import com.tos.androidlivedataviewmodel.projectOne.utils.Status
import com.tos.myapplication.data.api.RetrofitBuilder
import kotlinx.android.synthetic.main.fragment_movies.*


class MoviePagingFragment : Fragment(R.layout.fragment_movies),
    SwipeRefreshLayout.OnRefreshListener,
    movieInteractionListener {

    private lateinit var moviesFragmentViewModel: MoviesFragmentViewModel
    private lateinit var movieListAdapter: MoviePagingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moviesFragmentViewModel =
            ViewModelProvider(this, ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService, 1)))
                .get(
                    MoviesFragmentViewModel::class.java
                )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
//        obsStates()
        observableData()
    }

    private fun initUI() {
        swipe.setOnRefreshListener(this)
        movieListAdapter = MoviePagingAdapter(this)
        recyclerView.apply {
            this.layoutManager = gridLayoutManager()
            this.adapter = movieListAdapter
        }
    }

    private fun observableData() {
        activity?.let {
            moviesFragmentViewModel.getMovies().observe(it, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
//                            resource.data?.let { movie -> movieListAdapter.submitList(movie.results) }
                        }
                        Status.ERROR -> {
                        }
                        Status.LOADING -> {
                        }
                    }

                }
            })
        }
    }

    private fun gridLayoutManager(): RecyclerView.LayoutManager? {
        val mLayoutManager = GridLayoutManager(activity, 3)
        mLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (movieListAdapter.getItemViewType(position)) {
                    R.layout.loading_view_layout -> mLayoutManager.spanCount
                    else -> 1
                }
            }
        }
        return mLayoutManager
    }

    override fun onClickRetry() {
//        moviesFragmentViewModel.refreshFailedRequest()
    }

    override fun onMovieClick(movieResult: Result, pos: Int) {
        /*val bundle = bundleOf("movie" to movieResult)
        findNavController().navigate(R.id.detail_fragment, bundle)*/
    }

    private fun updateUIPaginationState(paginationState: PaginationState?) {
        when (paginationState) {
            PaginationState.LOADING -> {
                swipe.isRefreshing = true
            }
            PaginationState.EMPTY -> {
                swipe.isRefreshing = false
                if (movieListAdapter.currentList.isNullOrEmpty()) {
                }
            }
            PaginationState.ERROR -> {
                swipe.isRefreshing = false
                if (movieListAdapter.currentList.isNullOrEmpty()) {

                }
            }
            PaginationState.DONE -> {
                swipe.isRefreshing = false
            }
        }
    }

    override fun onRefresh() {
//        moviesFragmentViewModel.refreshAllList()
    }

}