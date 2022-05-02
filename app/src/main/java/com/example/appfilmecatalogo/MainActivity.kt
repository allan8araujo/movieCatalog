package com.example.appfilmecatalogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.appfilmecatalogo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        val movielistAdapter= MovieItemAdapter()
        biding.movieItemRecyclerView.adapter=movielistAdapter

        movielistAdapter.submitList()//passar os dados
    }

    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }
}