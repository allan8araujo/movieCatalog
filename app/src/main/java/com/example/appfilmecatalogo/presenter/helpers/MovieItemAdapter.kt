package com.example.appfilmecatalogo.presenter.helpers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.abstractions.models.PopularWeeklyFilms
import com.example.appfilmecatalogo.databinding.ListMoviesItemBinding

class MovieItemAdapter :
    ListAdapter<PopularWeeklyFilms, MovieItemAdapter.MovieItemViewHolder>(
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
        private val binding: ListMoviesItemBinding,
        private val onClickListener: ((movieId: Int) -> Unit)?,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: PopularWeeklyFilms) {
            binding.textMovieTitle.text = movie.title
            binding.shimmerMovie.showShimmer(true)

            Glide
                .with(binding.root.context)
                .load("https://image.tmdb.org/t/p/original" + movie.backdrop_path)
                .listener(GlideLoadingListener(binding.shimmerMovie, binding.imageMovie))
                .centerCrop()
                .into(binding.imageMovie)

            binding.imageMovie.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            binding.root.setOnClickListener {
                onClickListener?.invoke(movie.id)
            }
        }
    }
}
