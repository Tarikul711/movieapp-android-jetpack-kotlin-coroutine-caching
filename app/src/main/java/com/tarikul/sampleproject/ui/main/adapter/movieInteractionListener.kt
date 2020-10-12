package com.tarikul.sampleproject.ui.main.adapter

import com.tarikul.sampleproject.data.model.movieList.Result


interface movieInteractionListener {
    fun onClickRetry()
    fun onMovieClick(movieResult: Result, pos: Int)
}