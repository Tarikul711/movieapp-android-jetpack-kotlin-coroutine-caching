package com.tarikul.sampleproject.ui.main.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.tarikul.sampleproject.MoviesFragmentArgs
import com.tarikul.sampleproject.R
import kotlinx.android.synthetic.main.fragment_movies.*


class MoviesFragment : Fragment() {

    val args: MoviesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        tvTitle.text = args.movieType.toString()
        return view
    }
}