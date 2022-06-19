package com.example.appfilmecatalogo.presenter.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appfilmecatalogo.databinding.ActivitySplashScreenBinding

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
            biding.animationTap.playAnimation()
        }, 1000)
    }
}
