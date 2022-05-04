package com.example.appfilmecatalogo.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.repository.IMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieViewModel (
    private val movieRepository: IMovieRepository
        )
    : ViewModel() {

    //    val errorMessage = MutableLiveData<String>()
    private val livelist = MutableLiveData<Lives>()
    val movies: LiveData<Lives> = livelist

    fun getAllLives() {
        viewModelScope.launch {
            val movieFromApi = withContext(Dispatchers.IO) {
                movieRepository.getAllLives()
            }
            livelist.value=movieFromApi
        }
    }
//
//    fun getAllLives() {
//        val request = repository.getAllLives()
//        request.enqueue(object : Callback<List<Lives>> {
//            override fun onResponse(call: Call<List<Lives>>, response: Response<List<PopularWeeklyFilms>>) {
//                livelist.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<List<Lives>>, t: Throwable) {
//                errorMessage.postValue(t.message)
//            }
//
//        })
//    }
}