package com.example.appfilmecatalogo.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.appfilmecatalogo.R
import com.example.appfilmecatalogo.databinding.FragmentMovieDetailImageBinding
import com.example.appfilmecatalogo.presenter.util.FragmentReplacer
import com.example.appfilmecatalogo.presenter.viewmodel.Movie.MovieDetailsViewModel

class MovieDetailImageFragment : Fragment() {
    private val movieModelViewDetail: MovieDetailsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentMovieDetailImageBinding.inflate(inflater, container, false)
        val view = binding.root

        val movieSelected = movieModelViewDetail.selectedMovie.value
        Glide.with(binding.root.context)
            .load("https://image.tmdb.org/t/p/original" + movieSelected?.poster_path)
            .placeholder(R.drawable.loading_details)
            .centerCrop()
            .into(binding.imageDetail)

        binding.imageDetailBack.setOnClickListener {
            val transaction =
                (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
            FragmentReplacer().movieReplaceFragment(MovieDetailFragment(), transaction)
        }
        return view
    }
}
