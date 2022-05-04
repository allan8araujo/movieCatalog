package com.example.appfilmecatalogo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfilmecatalogo.databinding.ListMoviesItemBinding
import com.example.appfilmecatalogo.models.PopularWeeklyFilms

class MovieItemAdapter :
    ListAdapter<PopularWeeklyFilms, MovieItemAdapter.MovieItemViewHolder>(DIF_CALLBACK) {

    var onClickListener: ((movieId: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val biding =
            ListMoviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieItemViewHolder(biding, onClickListener)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovieItemViewHolder(
        private val biding: ListMoviesItemBinding,
        private val onClickListener: ((movieId: Int) -> Unit)?
    ) : RecyclerView.ViewHolder(biding.root) {
        fun bind(movie: PopularWeeklyFilms) {
            biding.textMovieTitle.text = movie.title

            Glide
                .with(biding.root.context)
                .load("https://image.tmdb.org/t/p/original" + movie.backdrop_path)
                .centerCrop()
                .into(biding.imageMovie)

            biding.root.setOnClickListener {
                onClickListener?.invoke(movie.id)
            }
        }

    }

    companion object {

        private val DIF_CALLBACK = object : DiffUtil.ItemCallback<PopularWeeklyFilms>() {
            override fun areItemsTheSame(
                oldItem: PopularWeeklyFilms,
                newItem: PopularWeeklyFilms
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: PopularWeeklyFilms,
                newItem: PopularWeeklyFilms
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

}