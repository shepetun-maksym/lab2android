package com.example.lab2android

sealed interface ListItem {
    data class HeaderItem(val title: String) : ListItem
    data class MovieItem(val movie: Movie) : ListItem
    data class BookItem(val book: Book) : ListItem
    data class MovieCarouselItem(val movies: List<Movie>) : ListItem
}

data class Movie(
    val id: Int,
    val title: String,
    val year: Int,
    val genres: List<String>
)

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val pages: Int
)