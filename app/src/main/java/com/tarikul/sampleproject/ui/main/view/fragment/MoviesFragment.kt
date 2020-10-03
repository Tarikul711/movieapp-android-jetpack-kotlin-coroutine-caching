package com.tarikul.sampleproject.ui.main.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.model.movies.Result
import com.tarikul.sampleproject.ui.base.ViewModelFactory
import com.tarikul.sampleproject.ui.main.adapter.MovieListAdapter
import com.tarikul.sampleproject.ui.main.adapter.TrendingMovieAdapter
import com.tarikul.sampleproject.ui.main.adapter.TvShowListAdapter
import com.tarikul.sampleproject.ui.main.viewmodel.HomeFragmentViewModel
import com.tarikul.sampleproject.ui.main.viewmodel.MoviesFragmentViewModel
import com.tos.androidlivedataviewmodel.projectOne.data.api.ApiHelperImpl
import com.tos.androidlivedataviewmodel.projectOne.utils.MovieType
import com.tos.androidlivedataviewmodel.projectOne.utils.MovieType.*
import com.tos.androidlivedataviewmodel.projectOne.utils.Status
import com.tos.myapplication.data.api.RetrofitBuilder
import kotlinx.android.synthetic.main.fragment_movies.*
import kotlinx.android.synthetic.main.fragment_movies.view.*


class MoviesFragment : Fragment() {

    private val args: MoviesFragmentArgs by navArgs()
    private lateinit var moviesFragmentViewModel: MoviesFragmentViewModel
    private lateinit var trendingMovieAdapter: TrendingMovieAdapter
    private lateinit var tvShowAdapter: TvShowListAdapter
    private lateinit var movieListAdapter: MovieListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        setupAdapter()
        setupView(view)
        setupViewModel()
        return view
    }


    private fun setupAdapter() {
        movieListAdapter = MovieListAdapter()
        trendingMovieAdapter = TrendingMovieAdapter()
        tvShowAdapter = TvShowListAdapter()
    }

    private fun setupView(view: View) {
        view.apply {
            when (args.movieType) {
                TRENDING -> {
                    recyclerView.adapter = TrendingMovieAdapter()
                    moviesFragmentViewModel.getTrendingMoviesData()
                    setupTrendingMovieObserver()
                }
                TVSHOW -> {
                    recyclerView.adapter = TvShowListAdapter()
                    moviesFragmentViewModel.getTvShowData()
                    setupTvShowObserver()
                }
                MOVIE -> {
                    recyclerView.adapter = MovieListAdapter()
                    moviesFragmentViewModel.getMoviesData()
                    setupMovieObserver()
                }
            }
        }
    }

    private fun setupViewModel() {
        moviesFragmentViewModel =
            ViewModelProvider(this, ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService, 1)))
                .get(
                    MoviesFragmentViewModel::class.java
                )
    }


    private fun bindMovieAdapter(results: List<Result>) {
        movieListAdapter.apply {
            progressbar.visibility = View.GONE
            swapData(results)
            notifyDataSetChanged()
        }
    }

    private fun bindTrendingMovieAdapter(results: List<com.tarikul.sampleproject.data.model.trending.Result>) {
        trendingMovieAdapter.apply {
            progressbar.visibility = View.GONE
            swapData(results)
            notifyDataSetChanged()
        }
    }

    private fun bindTvShowAdapter(results: List<com.tarikul.sampleproject.data.model.tvShows.Result>) {
        tvShowAdapter.apply {
            progressbar.visibility = View.GONE
            swapData(results)
            notifyDataSetChanged()
        }
    }


    private fun setupMovieObserver() {
        activity?.let {
            moviesFragmentViewModel.getMovies().observe(it, Observer {
                it?.let { resource ->
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
            moviesFragmentViewModel.getTrendingMovies().observe(it, Observer {
                it?.let { resource ->
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
            moviesFragmentViewModel.getTvShows().observe(it, Observer {
                it?.let { resource ->
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