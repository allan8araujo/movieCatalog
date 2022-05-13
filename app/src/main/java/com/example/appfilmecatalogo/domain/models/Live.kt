package com.example.appfilmecatalogo.domain.models

data class Lives(
    val page: Int,
    val results: MutableList<PopularWeeklyFilms>,
    val total_pages: Int,
    val total_results: Int,
)

fun mockLives() = Lives(
    1,
    mutableListOf(
        PopularWeeklyFilms(
            true,
            "a",
            listOf(33, 2, 1),
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
            listOf(33, 2, 1),
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
            listOf(33, 2, 1),
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
            listOf(33, 2, 1),
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
