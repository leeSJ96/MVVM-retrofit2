package com.example.mvvmp.ui.landing

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmp.model.Movie
import com.example.mvvmp.repository.MovieRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber

class LandigViewModel @ViewModelInject constructor(movieRepository: MovieRepository
): ViewModel() {
    private val _trendingMovies = MutableLiveData<List<Movie>>()
    val trendingMovies: LiveData<List<Movie>>
    get() = _trendingMovies

    init {
        movieRepository.getTrendingMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movies -> _trendingMovies.value = movies.results},
                {t -> Timber.e(t)})



            }

}