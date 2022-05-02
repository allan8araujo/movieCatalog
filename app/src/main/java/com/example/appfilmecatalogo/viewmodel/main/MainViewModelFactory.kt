package com.example.appfilmecatalogo.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appfilmecatalogo.repository.MainRepository
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory constructor (private val repository: MainRepository) :ViewModelProvider.Factory{
    override fun <T:ViewModel> create(modelClass: Class<T>):T{
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(this.repository) as T
        } else
        {
            throw IllegalArgumentException("Cant find viewmodel")
        }
    }
}