package com.example.appfilmecatalogo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.appfilmecatalogo.api.RetrofitService
import com.example.appfilmecatalogo.databinding.ActivityMainBinding
import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.repository.Interceptor
import com.example.appfilmecatalogo.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val retrofit by lazy {
        Retrofit.Builder()
           // .client(httpClient)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val movieClient: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }

    private val httpClient by lazy{
        OkHttpClient
            .Builder()
            .addInterceptor(Interceptor())
            .build()
    }



    private val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val movielistAdapter = MovieItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)

        movielistAdapter.onClickListener = { movieId ->
            goToMovieDetails(movieId)
        }
        biding.movieItemRecyclerView.adapter = movielistAdapter
       // movielistAdapter.submitList(mockLives().results)
        getMovies()
    }

    private fun getMovies() {
        lifecycleScope.launch {
            var listMovies:Lives
            withContext(Dispatchers.IO){
                val result= movieClient.getAllLives()
                listMovies=result
            }
            setListAdapter(listMovies)
        }
    }

    private fun setListAdapter(list:Lives){
        movielistAdapter.submitList(list.results)
    }

    private fun goToMovieDetails(movieId: Int) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("movieId", movieId)
//        intent.putExtra("mooviePhoto", moviePhoto)
        startActivity(intent)
    }
}
