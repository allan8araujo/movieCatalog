package com.example.appfilmecatalogo.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appfilmecatalogo.api.RetrofitService
import com.example.appfilmecatalogo.models.Lives
import com.example.appfilmecatalogo.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val livelist= MutableLiveData<List<Lives>>()
    val errorMessage= MutableLiveData<String>()

    fun getAllLives(){
        val request = repository.getAllLives()
        request.enqueue(object: Callback<List<Lives>> {
            override fun onResponse(call: Call<List<Lives>>, response: Response<List<Lives>>) {
                livelist.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Lives>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}