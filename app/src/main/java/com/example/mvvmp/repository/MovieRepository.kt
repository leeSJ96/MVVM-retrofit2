package com.example.mvvmp.repository

import com.example.mvvmp.model.Movies
import com.example.mvvmp.network.MovieService
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(  private val movieService : MovieService


){
        fun getTrendingMovie(): Single<Movies>{
            return movieService.getTrendingMoview()

                .subscribeOn(Schedulers.io())     }

}