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

class MovieListViewModel(var movieListRepository: MovieListRepository) : ViewModel() {

    private var movies = MutableLiveData<Resource<MovieResponse>>();
    private var trendingMovies = MutableLiveData<Resource<TrendingResponse>>();
    private var tvShows = MutableLiveData<Resource<TvShowResponse>>();

    init {
        getAllMovies()
        getTrendMovies()
    }

    private fun getAllMovies() = viewModelScope.launch {
        movies.postValue(Resource.loading(data = null))
        movieListRepository.getMovies()
            .catch { movies.postValue(Resource.error(null, "Error Occurred")) }
            .collect {
                movies.postValue(Resource.success(it))
            }
    }

    private fun getTrendMovies() = viewModelScope.launch {
        trendingMovies.postValue(Resource.loading(data = null))
        movieListRepository.getTrendingMovies()
            .catch { trendingMovies.postValue(Resource.error(null, "Error Occurred")) }
            .collect {
                trendingMovies.postValue(Resource.success(it))
            }
    }

    private fun getTvShow() = viewModelScope.launch {
        tvShows.postValue(Resource.loading(data = null))
        movieListRepository.getTvShows()
            .catch { tvShows.postValue(Resource.error(null, "Error Occurred")) }
            .collect {
                tvShows.postValue(Resource.success(it))
            }
    }

    fun getMovies(): MutableLiveData<Resource<MovieResponse>> {
        return movies
    }

    fun getTrendingMovies(): MutableLiveData<Resource<TrendingResponse>> {
        return trendingMovies
    }

    fun getTvShows(): MutableLiveData<Resource<TvShowResponse>> {
        return tvShows
    }
}