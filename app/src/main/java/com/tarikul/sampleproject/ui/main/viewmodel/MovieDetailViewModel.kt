package com.tarikul.sampleproject.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tarikul.sampleproject.data.model.movie.MovieResponse
import com.tarikul.sampleproject.data.repository.MovieDetailRepository
import com.tos.androidlivedataviewmodel.projectOne.utils.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 *Created by tarikul on 16/9/20
 */

class MovieDetailViewModel(private var movieDetailRepository: MovieDetailRepository) : ViewModel() {

    private var movieDetail = MutableLiveData<Resource<MovieResponse>>()

    init {
        getMovieInfo()
    }

    private fun getMovieInfo() = viewModelScope.launch {
        movieDetail.postValue(Resource.loading(data = null))
        movieDetailRepository.getMovieDetails()
            .catch { movieDetail.postValue(Resource.error(null, "Error Occurred")) }
            .collect {
                movieDetail.postValue(Resource.success(it))
            }
    }

    fun getMovieDetail() = movieDetail
}
