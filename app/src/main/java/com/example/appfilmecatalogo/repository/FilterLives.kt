package com.example.appfilmecatalogo.repository

import com.example.appfilmecatalogo.models.Lives

object FilterLives {
    fun filterByVote(list:Lives):Lives{
        list.results.sortBy {
            it.vote_average
        }
        return list
    }

    fun filterByAverage(list:Lives):Lives{
        list.results.sortBy {
            it.vote_average
        }
        return list

    }
    fun filterByPopularity(list: Lives): Lives {
        list.results.sortBy {
            it.popularity
        }
        return list
    }

    fun filterByReleaseDate(list: Lives): Lives {
        list.results.sortBy {
            it.release_date
        }
        return list
    }
}