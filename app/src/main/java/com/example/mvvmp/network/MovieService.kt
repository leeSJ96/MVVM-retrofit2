package com.example.mvvmp.network

import com.example.mvvmp.model.Movies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MovieService {

    @GET("trending/all/day?api_key=7b7f1dc7abeebcab655fc143184ea2dd")
    fun getTrendingMoview(): Single<Movies>
}