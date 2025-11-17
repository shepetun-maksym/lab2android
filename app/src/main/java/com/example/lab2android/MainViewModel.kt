package com.example.lab2android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var profileMessage by mutableStateOf("Це екран профілю")
        private set

    var favoritesMessage by mutableStateOf("Ваш список улюбленого порожній")
        private set

    var settingsMessage by mutableStateOf("Початкові налаштування системи")
        private set

    fun updateProfile() {
        profileMessage = "Профіль оновлено!"
    }

    fun updateFavorites() {
        favoritesMessage = "Додано новий улюблений елемент!"
    }

    fun updateSettings() {
        settingsMessage = "Налаштування збережено!"
    }
}