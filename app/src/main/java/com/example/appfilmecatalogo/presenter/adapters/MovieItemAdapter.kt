package com.example.appfilmecatalogo.presenter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appfilmecatalogo.R
import com.example.appfilmecatalogo.databinding.ListMoviesItemBinding

class MovieItemAdapter :
    ListAdapter<com.example.abstractions.models.PopularWeeklyFilms, MovieItemAdapter.MovieItemViewHolder>(
        DiffCallBack()
    ) {

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
        private val onClickListener: ((movieId: Int) -> Unit)?,
    ) : RecyclerView.ViewHolder(biding.root) {
        fun bind(movie: com.example.abstractions.models.PopularWeeklyFilms) {
            biding.textMovieTitle.text = movie.title
            Glide
                .with(biding.root.context)
                .load("https://image.tmdb.org/t/p/original" + movie.backdrop_path)
                .placeholder(R.drawable.pb_loading__)
                .centerCrop()
                .into(biding.imageMovie)

            biding.root.setOnClickListener {
                onClickListener?.invoke(movie.id)
            }
        }
    }
}
