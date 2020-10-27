package com.tarikul.sampleproject.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tarikul.sampleproject.data.model.movieList.MovieListResponse
import com.tarikul.sampleproject.data.model.trendingList.TrendingListResponse
import com.tarikul.sampleproject.data.model.tvShowList.TvShowListResponse
import com.tarikul.sampleproject.data.repository.MovieListRepository
import com.tos.androidlivedataviewmodel.projectOne.utils.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *Created by tarikul on 16/9/20
 */

class HomeFragmentViewModel(private var movieListRepository: MovieListRepository) : ViewModel() {

    private var movies = MutableLiveData<Resource<MovieListResponse>>();
    private var trendingMovies = MutableLiveData<Resource<TrendingListResponse>>();
    private var tvShows = MutableLiveData<Resource<TvShowListResponse>>();

    init {
        getAllMovies()
        getTrendMovies()
        getTvShow()
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

    fun getMovies() = movies
    fun getTrendingMovies() = trendingMovies
    fun getTvShows() = tvShows
}