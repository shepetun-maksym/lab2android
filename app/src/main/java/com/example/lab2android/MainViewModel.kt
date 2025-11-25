package com.example.lab2android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel(
    private val repository: FavoritesRepository = FavoritesRepository()
) : ViewModel() {

    var profileMessage by mutableStateOf("Це екран профілю")
        private set

    var settingsMessage by mutableStateOf("Початкові налаштування системи")
        private set

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var books by mutableStateOf<List<Book>>(emptyList())
        private set

    init {
        loadData()
    }

    private fun loadData() {
        movies = repository.getMovies()
        books = repository.getBooks()
    }

    fun updateProfile() {
        profileMessage = "Профіль оновлено!"
    }

    fun updateSettings() {
        settingsMessage = "Налаштування збережено!"
    }
}