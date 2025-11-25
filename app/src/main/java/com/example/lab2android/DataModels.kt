package com.example.lab2android
data class Movie(
    val title: String,
    val year: Int,
    val genres: List<String>
)

data class Book(
    val title: String,
    val author: String,
    val pages: Int
)