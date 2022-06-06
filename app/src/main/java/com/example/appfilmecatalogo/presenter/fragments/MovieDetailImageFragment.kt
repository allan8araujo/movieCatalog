package com.example.appfilmecatalogo.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.appfilmecatalogo.R
import com.example.appfilmecatalogo.databinding.FragmentMovieDetailImageBinding
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

        binding.imageDetail.setImageBitmap(movieModelViewDetail.selectedImage.value)

        binding.imageDetailBack.setOnClickListener {
            findNavController().navigate(R.id.back_to_movieDetailFragment)
        }
        return view
    }
}
