package com.example.appfilmecatalogo.presenter.util

import com.example.appfilmecatalogo.domain.models.Lives

enum class FilterTypes {
    VOTES_AVERAGE {
        override fun FilterTypes(list: Lives): Lives {
            list.results.sortByDescending {
                it.vote_average
            }
            return list
        }
    },
    POPULARITY {
        override fun FilterTypes(list: Lives): Lives {
            list.results.sortByDescending {
                it.popularity
            }
            return list
        }
    },
    RELEASE_DATE {
        override fun FilterTypes(list: Lives): Lives {
            list.results.sortByDescending {
                it.release_date
            }
            return list
        }
    },
    TITLE {
        override fun FilterTypes(list: Lives): Lives {
            list.results.sortBy {
                it.title
            }
            return list
        }
    };

    abstract fun FilterTypes(list: Lives): Lives
}
