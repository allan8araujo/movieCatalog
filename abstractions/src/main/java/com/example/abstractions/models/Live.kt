package com.example.abstractions.models

data class Lives(
    val page: Int? = null,
    val results: MutableList<PopularWeeklyFilms>?,
    val total_pages: Int? = null,
    val total_results: Int? = null,
)

fun emptyLiveList() = Lives(
    1,
    mutableListOf(
        PopularWeeklyFilms(
            true,
            "a",
            3,
            "en",
            "2",
            "2",
            3f,
            "pathh_post",
            "20-02-010",
            "Erro ao carregar... ",
            true,
            32.2f,
            2,
            "3"
        ),
        PopularWeeklyFilms(
            true,
            "c",
            4,
            "en",
            "2",
            "2",
            1f,
            "pathh_post",
            "20-02-010",
            "Erro ao carregar...",
            true,
            32.2f,
            2,
            "3"
        ),
        PopularWeeklyFilms(
            true,
            "b",
            4,
            "en",
            "2",
            "2",
            2f,
            "pathh_post",
            "20-02-010",
            "Erro ao carregar...",
            true,
            32.2f,
            2,
            "3"
        ),
        PopularWeeklyFilms(
            true,
            "filme",
            4,
            "en",
            "2",
            "2",
            3f,
            "pathh_post",
            "20-02-010",
            "Erro ao carregar...",
            true,
            32.2f,
            2,
            "3"
        )
    ),
    1000,
    1000
)
