package com.example.appfilmecatalogo.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfilmecatalogo.databinding.ActivitySplashScreenBinding
import com.example.appfilmecatalogo.presenter.view.ListActivity

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var biding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(biding.root)
        val varTitulo = biding.textLogo
        varTitulo.animate().translationY(-725f).duration = 2500
        varTitulo.postDelayed({
            val intent = Intent(this, ListActivity::class.java)

            startActivity(intent)
            finish()
        }, 2100)

        biding.animationTap.postDelayed({
            val teste= biding.animationTap.playAnimation()
        },1000)
    }


}