package com.example.mvvmp.ui.landing

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_landing.*
import timber.log.Timber


@AndroidEntryPoint
class LandingFragment : Fragment(R.layout.fragment_landing) {

    private lateinit var movieAdapter: MovieAdapter

    private val landigViewModel by viewModels<LandigViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAdapter = MovieAdapter()

        rvMovie.layoutManager = LinearLayoutManager(requireContext())
        rvMovie.adapter = movieAdapter
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        landigViewModel.trendingMovies.observe(viewLifecycleOwner, Observer {
            movieAdapter.setMovies(it)
        })
    }



}