package com.tarikul.sampleproject.ui.main.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.ui.base.ViewModelFactory
import com.tarikul.sampleproject.ui.main.viewmodel.HomeFragmentViewModel
import com.tarikul.sampleproject.ui.main.viewmodel.MovieDetailViewModel
import com.tos.androidlivedataviewmodel.projectOne.data.api.ApiHelperImpl
import com.tos.myapplication.data.api.RetrofitBuilder

class MovieDetailFragment : Fragment() {

    private lateinit var movieDetailViewModel: MovieDetailViewModel
//    private var args: MovieDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie_detail, container, false)

        return view
    }

    private fun setupUI() {}
    private fun setupViewModel() {
        movieDetailViewModel =
            ViewModelProvider(
                this,
                ViewModelFactory(
                    ApiHelperImpl(
                        apiService = RetrofitBuilder.apiService,
                        movie_id = ""
                    )
                )
            )
                .get(
                    MovieDetailViewModel::class.java
                )
    }

    private fun setupMovieDetailObserver() {}

}