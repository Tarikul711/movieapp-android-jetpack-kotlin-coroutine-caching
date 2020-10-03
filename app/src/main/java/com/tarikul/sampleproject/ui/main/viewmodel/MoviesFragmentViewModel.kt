package com.tarikul.sampleproject.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.tarikul.sampleproject.data.model.movies.MovieResponse
import com.tarikul.sampleproject.data.model.trending.TrendingResponse
import com.tarikul.sampleproject.data.model.tvShows.TvShowResponse
import com.tarikul.sampleproject.data.repository.MovieListRepository
import com.tos.androidlivedataviewmodel.projectOne.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *Created by tarikul on 16/9/20
 */

class MoviesFragmentViewModel(private var movieListRepository: MovieListRepository) : ViewModel() {

    private var trendingMovies = MutableLiveData<Resource<TrendingResponse>>()
    private var tvShows = MutableLiveData<Resource<TvShowResponse>>()
    private var movies = MutableLiveData<Resource<MovieResponse>>()

    init {

    }

    fun getMoviesData() = viewModelScope.launch {
        movies.postValue(Resource.loading(data = null))
        movieListRepository.getMovies()
            .catch { movies.postValue(Resource.error(null, "Error Occurred")) }
            .collect {
                movies.postValue(Resource.success(it))
            }
    }

    fun getTrendingMovies() = trendingMovies
    fun getTvShows() = tvShows
    fun getMovies() = movies
}