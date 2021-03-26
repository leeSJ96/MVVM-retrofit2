package com.example.mvvmp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movies (
    val page: Long,
    @Json(name = "total_pages")
    val total_pages : Long,
    @Json(name = "total_results")
    val total_results : Long,
    val results: List<Movie>
  )

@JsonClass(generateAdapter = true)
data class Movie(
    val id: Long?,
    val video: Boolean?,
    @Json(name = "vote_count")
    val voteCount: Long?,
    @Json(name = "vote_average")
    val voteAverage: Double?,
    val title: String?,
    @Json(name = "release_date")
    val releaseDate: String?,
    @Json(name = "original_Language")
    val originalLanguage: String?,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    val adult: Boolean?,
    val overView: String?,
    @Json(name = "poster_path")
    val posterPath: String?,
    val popularity: Double?,
    @Json(name = "media_type")
    val mediaType: String?,

)
