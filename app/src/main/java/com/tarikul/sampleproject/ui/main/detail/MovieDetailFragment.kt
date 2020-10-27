package com.tarikul.sampleproject.ui.main.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.api.BaseUrl
import com.tarikul.sampleproject.data.model.movie.MovieResponse
import com.tarikul.sampleproject.data.model.movieList.MovieListResponse
import com.tarikul.sampleproject.ui.base.ViewModelFactory
import com.tarikul.sampleproject.ui.main.home.adapter.MovieListAdapter
import com.tos.androidlivedataviewmodel.projectOne.data.api.ApiHelperImpl
import com.tos.androidlivedataviewmodel.projectOne.utils.Status
import com.tos.myapplication.data.api.RetrofitBuilder
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*

class MovieDetailFragment : Fragment() {

    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var movieDetailViewModel: MovieDetailViewModel
    private val args: MovieDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie_detail, container, false)
        setupViewModel()
        setupRecyclerView(view)
        setupMovieDetailObserver(view)
        setupSimilarMovieObserver(view)
        return view
    }

    private fun setupRecyclerView(view: View) {
        movieListAdapter =
            MovieListAdapter()
        view.apply {
            similarMovieRecyclerview.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            similarMovieRecyclerview.adapter = movieListAdapter
        }
    }

    private fun setupViewModel() {
        movieDetailViewModel =
            ViewModelProvider(
                this,
                ViewModelFactory(
                    ApiHelperImpl(
                        apiService = RetrofitBuilder.apiService,
                        movie_id = args.movieId
                    )
                )
            )
                .get(
                    MovieDetailViewModel::class.java
                )
    }

    private fun setupMovieDetailObserver(view: View) {
        activity?.let {
            movieDetailViewModel.getMovieDetail().observe(it, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { movie -> setupUI(movie, view) }
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

    private fun setupSimilarMovieObserver(view: View) {
        activity?.let {
            movieDetailViewModel.getSimilarMovieDetail().observe(it, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { movie -> setupSimilarMoviesUI(view, movie) }
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

    private fun setupUI(movie: MovieResponse, view: View) {
        view.apply {
            Glide.with(ivBackdrop)
                .load("${BaseUrl.BASE_IMAGES_URL}${movie.backdrop_path}")
                .into(ivBackdrop)

            Glide.with(ivPoster)
                .load("${BaseUrl.BASE_IMAGES_URL}${movie.poster_path}")
                .into(ivPoster)
            tvMovieTitleValue.text = movie.title
            tvVoteAverage.text = movie.vote_average.toString()

            tvDescriptionTitle.text = "Description"
            tvDescriptionValue.text = movie.overview
            tvQuoteValue.text = movie.status
            tvTaglineTitle.text = movie.tagline

        }
    }

    private fun setupSimilarMoviesUI(view: View, movies: MovieListResponse) {
        movieListAdapter.apply {
            swapData(movies.results)
            notifyDataSetChanged()
        }
    }

}