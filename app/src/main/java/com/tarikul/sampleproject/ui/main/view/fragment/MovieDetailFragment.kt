package com.tarikul.sampleproject.ui.main.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.model.movie.MovieResponse
import com.tarikul.sampleproject.ui.base.ViewModelFactory
import com.tarikul.sampleproject.ui.main.viewmodel.MovieDetailViewModel
import com.tos.androidlivedataviewmodel.projectOne.data.api.ApiHelperImpl
import com.tos.androidlivedataviewmodel.projectOne.utils.Status
import com.tos.myapplication.data.api.RetrofitBuilder
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*

class MovieDetailFragment : Fragment() {

    private lateinit var movieDetailViewModel: MovieDetailViewModel
    private val args: MovieDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie_detail, container, false)
        setupViewModel()
        setupMovieDetailObserver(view)
        return view
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

    private fun setupUI(movie: MovieResponse, view: View) {
        view.apply {
            tvMovieTitle.text = movie.original_title
        }
    }

}