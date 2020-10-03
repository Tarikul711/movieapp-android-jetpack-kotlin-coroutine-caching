package com.tarikul.sampleproject.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tarikul.sampleproject.data.repository.MovieListRepository
import com.tarikul.sampleproject.ui.main.viewmodel.HomeFragmentViewModel
import com.tarikul.sampleproject.ui.main.viewmodel.MoviesFragmentViewModel
import com.tos.myapplication.data.api.ApiHelper

/**
 *Created by tarikul on 16/9/20
 */
class ViewModelFactory(val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
            return HomeFragmentViewModel(MovieListRepository(apiHelper)) as T
        }
        if (modelClass.isAssignableFrom(MoviesFragmentViewModel::class.java)) {
            return MoviesFragmentViewModel(MovieListRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}