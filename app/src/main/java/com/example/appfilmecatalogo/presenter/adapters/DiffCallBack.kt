package com.example.appfilmecatalogo.presenter.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.abstractions.models.PopularWeeklyFilms

class DiffCallBack : DiffUtil.ItemCallback<com.example.abstractions.models.PopularWeeklyFilms>() {
    override fun areItemsTheSame(
        oldItem: com.example.abstractions.models.PopularWeeklyFilms,
        newItem: com.example.abstractions.models.PopularWeeklyFilms,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: com.example.abstractions.models.PopularWeeklyFilms,
        newItem: com.example.abstractions.models.PopularWeeklyFilms,
    ): Boolean {
        return oldItem == newItem
    }
}
