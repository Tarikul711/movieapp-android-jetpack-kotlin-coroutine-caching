package com.tarikul.sampleproject.ui.main.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.model.movieList.Result as Result
import com.tarikul.sampleproject.data.model.trendingList.Result as TrendResult
import com.tarikul.sampleproject.data.model.tvShowList.Result as TvShowResult
import com.tarikul.sampleproject.ui.base.ViewModelFactory
import com.tarikul.sampleproject.ui.main.adapter.MovieListAdapter
import com.tarikul.sampleproject.ui.main.adapter.TrendingMovieAdapter
import com.tarikul.sampleproject.ui.main.adapter.TvShowListAdapter
import com.tarikul.sampleproject.ui.main.viewmodel.HomeFragmentViewModel
import com.tos.androidlivedataviewmodel.projectOne.data.api.ApiHelperImpl
import com.tos.androidlivedataviewmodel.projectOne.utils.MovieType.*
import com.tos.androidlivedataviewmodel.projectOne.utils.Status
import com.tos.myapplication.data.api.RetrofitBuilder
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var trendingMovieAdapter: TrendingMovieAdapter
    private lateinit var tvShowAdapter: TvShowListAdapter
    private lateinit var movieViewModel: HomeFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setupAdapter()
        setupUI(view)
        setupViewModel()
        setupMovieObserver()
        setupTrendingMovieObserver()
        setupTvShowObserver()
        setupMovieFragment(view)
        return view
    }

    private fun setupAdapter() {
        movieListAdapter = MovieListAdapter()
        trendingMovieAdapter = TrendingMovieAdapter()
        tvShowAdapter = TvShowListAdapter()
    }


    private fun setupUI(view: View) {
        view.apply {
            upComingRecyclerView.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            upComingRecyclerView.adapter = movieListAdapter

            recyclerView.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = trendingMovieAdapter

            tvShowRecyclerView.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            tvShowRecyclerView.adapter = tvShowAdapter
        }
    }

    private fun setupMovieFragment(view: View) {

        view.apply {
            tvTrendingSeeAll.setOnClickListener {
                val action = HomeFragmentDirections.trendingToMoviesFragment(TRENDING)
                findNavController().navigate(action)
            }
            tvTvShow.setOnClickListener {
                val action = HomeFragmentDirections.trendingToMoviesFragment(TVSHOW)
                findNavController().navigate(action)
            }
            tvUpComing.setOnClickListener {
                val action = HomeFragmentDirections.trendingToMoviesFragment(MOVIE)
                findNavController().navigate(action)
            }
        }
    }

    private fun bindMovieAdapter(results: List<Result>) {
        movieListAdapter.apply {
            swapData(results)
            notifyDataSetChanged()
        }
    }

    private fun bindTrendingMovieAdapter(results: List<TrendResult>) {
        trendingMovieAdapter.apply {
            swapData(results)
            notifyDataSetChanged()
        }
    }

    private fun bindTvShowAdapter(results: List<TvShowResult>) {
        tvShowAdapter.apply {
            swapData(results)
            notifyDataSetChanged()
        }
    }

    private fun setupViewModel() {
        movieViewModel =
            ViewModelProvider(this, ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService, 1)))
                .get(
                    HomeFragmentViewModel::class.java
                )
    }

    private fun setupMovieObserver() {
        activity?.let {
            movieViewModel.getMovies().observe(it, Observer {
                it.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { movie -> bindMovieAdapter(movie.results) }
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

    private fun setupTrendingMovieObserver() {
        activity?.let {
            movieViewModel.getTrendingMovies().observe(it, Observer {
                it.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { movie -> bindTrendingMovieAdapter(movie.results) }
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

    private fun setupTvShowObserver() {
        activity?.let {
            movieViewModel.getTvShows().observe(it, Observer {
                it.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { movie -> bindTvShowAdapter(movie.results) }
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
}