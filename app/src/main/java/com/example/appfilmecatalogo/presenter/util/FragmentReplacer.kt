package com.example.appfilmecatalogo.presenter.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.appfilmecatalogo.R

class FragmentReplacer {
    fun movieReplaceFragment(fragment: Fragment, transaction: FragmentTransaction) {
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}
