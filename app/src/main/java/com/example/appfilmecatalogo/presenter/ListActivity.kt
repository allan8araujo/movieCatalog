package com.example.appfilmecatalogo.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appfilmecatalogo.databinding.ActivityMainBinding

class ListActivity : AppCompatActivity() {
    private val biding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
    }
}
