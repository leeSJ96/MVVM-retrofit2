package com.example.mvvmp.ui.landing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmp.R
import com.example.mvvmp.glide.GlideApp
import com.example.mvvmp.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movies: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :MovieViewHolder {
        return MovieViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
       val movie = movies[position]
        holder.bind(movie)
    }

    fun setMovies(movies: List<Movie>){
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = movies.size


    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(movie: Movie){
            itemView.apply {

                GlideApp.with(ivPoster)
                    .load("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
                    .into(ivPoster)
                tvtitle.text = movie.title
                tvReleaseDate.text = movie.releaseDate
                tvOverview.text = movie.overView


            }


        }

        companion object {
            fun from(parent: ViewGroup): MovieViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val itemView = inflater.inflate(R.layout.item_movie, parent, false)
                return MovieViewHolder(itemView)

            }
        }
    }


}