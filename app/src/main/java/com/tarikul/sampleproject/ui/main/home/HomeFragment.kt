package com.tarikul.sampleproject.ui.main.home


import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tarikul.sampleproject.R
import com.tarikul.sampleproject.data.model.movieList.Result as Result
import com.tarikul.sampleproject.data.model.trendingList.Result as TrendResult
import com.tarikul.sampleproject.data.model.tvShowList.Result as TvShowResult
import com.tarikul.sampleproject.ui.base.ViewModelFactory
import com.tarikul.sampleproject.ui.main.home.adapter.MovieListAdapter
import com.tarikul.sampleproject.ui.main.home.adapter.TrendingMovieAdapter
import com.tarikul.sampleproject.ui.main.home.adapter.TvShowListAdapter
import com.tos.androidlivedataviewmodel.projectOne.data.api.ApiHelperImpl
import com.tos.androidlivedataviewmodel.projectOne.utils.MovieType.*
import com.tos.androidlivedataviewmodel.projectOne.utils.Status
import com.tos.myapplication.data.api.RetrofitBuilder
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var movieListAdapter: MovieListAdapter
    private lateinit var trendingMovieAdapter: TrendingMovieAdapter
    private lateinit var tvShowAdapter: TvShowListAdapter
    private lateinit var movieViewModel: HomeFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.textView2.text=Html.fromHtml("<math xmlns=\"http://www.w3.org/1998/Math/MathML\" display=\"block\">\n" +
                "  <mfenced open=\"[\" close=\"]\">\n" +
                "    <mtable rowspacing=\"4pt\" columnspacing=\"1em\">\n" +
                "      <mtr>\n" +
                "        <mtd>\n" +
                "          <mi>a</mi>\n" +
                "        </mtd>\n" +
                "        <mtd>\n" +
                "          <mi>b</mi>\n" +
                "        </mtd>\n" +
                "      </mtr>\n" +
                "      <mtr>\n" +
                "        <mtd>\n" +
                "          <mi>c</mi>\n" +
                "        </mtd>\n" +
                "        <mtd>\n" +
                "          <mi>d</mi>\n" +
                "        </mtd>\n" +
                "      </mtr>\n" +
                "    </mtable>\n" +
                "  </mfenced>\n" +
                "</math>",Html.FROM_HTML_MODE_COMPACT)
        /* setupAdapter()
         setupUI(view)
         setupViewModel()
         setupMovieObserver()
         setupTrendingMovieObserver()
         setupTvShowObserver()
         setupMovieFragment(view)*/
        return view
    }

    private fun setupAdapter() {
        movieListAdapter =
            MovieListAdapter()
        trendingMovieAdapter =
            TrendingMovieAdapter()
        tvShowAdapter =
            TvShowListAdapter()
    }


    private fun setupUI(view: View) {
        view.apply {
            upComingRecyclerView.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            upComingRecyclerView.adapter = movieListAdapter

            recyclerView.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.adapter = trendingMovieAdapter

            tvShowRecyclerView.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            tvShowRecyclerView.adapter = tvShowAdapter
        }
    }

    private fun setupMovieFragment(view: View) {

        view.apply {
            tvTrendingSeeAll.setOnClickListener {
                val action =
                    HomeFragmentDirections.trendingToMoviesFragment(
                        TRENDING
                    )
                findNavController().navigate(action)
            }
            tvTvShow.setOnClickListener {
                val action =
                    HomeFragmentDirections.trendingToMoviesFragment(
                        TVSHOW
                    )
                findNavController().navigate(action)
            }
            tvUpComing.setOnClickListener {
                val action =
                    HomeFragmentDirections.trendingToMoviesFragment(
                        MOVIE
                    )
                findNavController().navigate(action)
            }
        }
    }

    private fun bindMovieAdapter(results: List<Result>) {
        movieListAdapter.apply {
            swapData(results)
            notifyDataSetChanged()
        }
    }

    private fun bindTrendingMovieAdapter(results: List<TrendResult>) {
        trendingMovieAdapter.apply {
            swapData(results)
            notifyDataSetChanged()
        }
    }

    private fun bindTvShowAdapter(results: List<TvShowResult>) {
        tvShowAdapter.apply {
            swapData(results)
            notifyDataSetChanged()
        }
    }

    private fun setupViewModel() {
        movieViewModel =
            ViewModelProvider(this, ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService, 1)))
                .get(
                    HomeFragmentViewModel::class.java
                )
    }

    private fun setupMovieObserver() {
        activity?.let {
            movieViewModel.getMovies().observe(it, Observer {
                it.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { movie -> bindMovieAdapter(movie.results) }
                        }
                        Status.ERROR -> {
                        }
                        Status.LOADING -> {
                        }
                    }

                }
            })
        }
    }

    private fun setupTrendingMovieObserver() {
        activity?.let {
            movieViewModel.getTrendingMovies().observe(it, Observer {
                it.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { movie -> bindTrendingMovieAdapter(movie.results) }
                        }
                        Status.ERROR -> {
                        }
                        Status.LOADING -> {
                        }
                    }

                }
            })
        }
    }

    private fun setupTvShowObserver() {
        activity?.let {
            movieViewModel.getTvShows().observe(it, Observer {
                it.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            resource.data?.let { movie -> bindTvShowAdapter(movie.results) }
                        }
                        Status.ERROR -> {
                        }
                        Status.LOADING -> {
                        }
                    }

                }
            })
        }
    }
}