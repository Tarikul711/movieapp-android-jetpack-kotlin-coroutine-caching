package com.tarikul.sampleproject.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.tarikul.sampleproject.data.model.movies.MovieResponse
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

    init {
        getAllMovies()
    }

    private fun getAllMovies() = viewModelScope.launch {
        movies.postValue(Resource.loading(data = null))
        movieListRepository.getMovies()
            .catch { movies.postValue(Resource.error(null, "Error Occurred")) }
            .collect {
                movies.postValue(Resource.success(it))
            }
        /* emit(Resource.loading(data = null))
         try {
             emit(Resource.success(data = photoAlbumRepository.getPhotoAlbum()))
         } catch (exception: Exception) {
             emit(Resource.error(data = null, message = exception.message ?: "Error Occurred"))
         }*/
    }

    fun getPhotoData(): MutableLiveData<Resource<MovieResponse>> {
        return movies
    }
}