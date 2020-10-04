package com.tarikul.sampleproject.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tarikul.sampleproject.data.model.movieList.MovieResponse
import com.tarikul.sampleproject.data.model.trendingList.TrendingResponse
import com.tarikul.sampleproject.data.model.tvShowList.TvShowResponse
import com.tarikul.sampleproject.data.repository.MovieListRepository
import com.tos.androidlivedataviewmodel.projectOne.utils.Resource
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

    fun getMoviesData() = viewModelScope.launch {
        movies.postValue(Resource.loading(data = null))
        movieListRepository.getMovies()
            .catch { movies.postValue(Resource.error(null, "Error Occurred")) }
            .collect {
                movies.postValue(Resource.success(it))
            }
    }

    fun getTrendingMoviesData() = viewModelScope.launch {
        trendingMovies.postValue(Resource.loading(data = null))
        movieListRepository.getTrendingMovies()
            .catch { trendingMovies.postValue(Resource.error(null, "Error Occurred")) }
            .collect {
                trendingMovies.postValue(Resource.success(it))
            }
    }

    fun getTvShowData() = viewModelScope.launch {
        tvShows.postValue(Resource.loading(data = null))
        movieListRepository.getTvShows()
            .catch { tvShows.postValue(Resource.error(null, "Error Occurred")) }
            .collect {
                tvShows.postValue(Resource.success(it))
            }
    }

    fun getTrendingMovies() = trendingMovies
    fun getTvShows() = tvShows
    fun getMovies() = movies
}