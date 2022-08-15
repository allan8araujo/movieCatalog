package com.example.app_tv_module.activities

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.app_tv_module.fragments.PlaybackVideoFragment

/** Loads [PlaybackVideoFragment]. */
class PlaybackActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, PlaybackVideoFragment())
                .commit()
        }
    }
}