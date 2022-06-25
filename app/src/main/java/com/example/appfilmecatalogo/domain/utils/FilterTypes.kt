package com.example.appfilmecatalogo.domain.utils

import com.example.abstractions.models.Lives

enum class FilterTypes {
    VOTES_AVERAGE {
        override fun filterTypes(list: Lives): Lives {
            list.results?.sortByDescending {
                it.vote_average
            }
            return list
        }
    },
    POPULARITY {
        override fun filterTypes(list: Lives): Lives {
            list.results?.sortByDescending {
                it.popularity
            }
            return list
        }
    },
    RELEASE_DATE {
        override fun filterTypes(list: Lives): Lives {
            list.results?.sortByDescending {
                it.release_date
            }
            return list
        }
    },
    TITLE {
        override fun filterTypes(list: Lives): Lives {
            list.results?.sortBy {
                it.title
            }
            return list
        }
    };

    abstract fun filterTypes(list: Lives): Lives
}
