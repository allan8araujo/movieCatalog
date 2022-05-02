package com.example.appfilmecatalogo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appfilmecatalogo.databinding.ListMoviesItemBinding
import com.example.appfilmecatalogo.models.PopularWeeklyFilms

class MovieItemAdapter :
    ListAdapter<PopularWeeklyFilms, MovieItemAdapter.MovieItemViewHolder>(DIF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val biding =
            ListMoviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieItemViewHolder(biding)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovieItemViewHolder
        (private val biding: ListMoviesItemBinding) :
        RecyclerView.ViewHolder(biding.root) {
        fun bind(movie: PopularWeeklyFilms) {
            //passar os bangs do bind
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