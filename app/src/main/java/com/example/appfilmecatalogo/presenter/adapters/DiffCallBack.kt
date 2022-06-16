package com.example.appfilmecatalogo.presenter.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.appfilmecatalogo.domain.models.PopularWeeklyFilms

class DiffCallBack: DiffUtil.ItemCallback<PopularWeeklyFilms>() {
    override fun areItemsTheSame(
        oldItem: PopularWeeklyFilms,
        newItem: PopularWeeklyFilms,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: PopularWeeklyFilms,
        newItem: PopularWeeklyFilms,
    ): Boolean {
        return oldItem == newItem
    }
}