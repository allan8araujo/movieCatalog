package com.example.appfilmecatalogo.presenter.view

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
<<<<<<< HEAD:app/src/main/java/com/example/appfilmecatalogo/ui/SplashScreenActivity.kt
            val teste = biding.animationTap.playAnimation()
        }, 1000)
    }
}
=======
            biding.animationTap.playAnimation()
        },1000)
    }

}
>>>>>>> 87ebc20bd2d2fa33cf1f870e390e1730394a467e:app/src/main/java/com/example/appfilmecatalogo/presenter/view/SplashScreenActivity.kt
