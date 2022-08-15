package com.example.app_tv_module.activities

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.app_tv_module.R
import com.example.app_tv_module.fragments.MainFragment

/**
 * Loads [MainFragment].
 */
class MainActivityTV : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_tv)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_browse_fragment, MainFragment())
                .commitNow()
        }
    }
}