package com.tarikul.sampleproject.ui.main.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.model.movieList.Result
import com.tarikul.sampleproject.data.model.trendingList.Result as TrendingResult
import com.tarikul.sampleproject.data.model.tvShowList.Result as TvShowResult
import com.tarikul.sampleproject.ui.base.ViewModelFactory
import com.tarikul.sampleproject.ui.main.adapter.*
import com.tarikul.sampleproject.ui.main.viewmodel.MoviesFragmentViewModel
import com.tos.androidlivedataviewmodel.projectOne.data.api.ApiHelperImpl
import com.tos.androidlivedataviewmodel.projectOne.utils.MovieType.*
import com.tos.androidlivedataviewmodel.projectOne.utils.Status
import com.tos.myapplication.data.api.RetrofitBuilder
import kotlinx.android.synthetic.main.fragment_movies.view.*
import kotlinx.android.synthetic.main.fragment_movies.view.recyclerView


class MoviePagingFragment : Fragment(R.layout.fragment_movies),
    SwipeRefreshLayout.OnRefreshListener,
    movieInteractionListener {


}