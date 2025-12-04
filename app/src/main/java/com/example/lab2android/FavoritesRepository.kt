package com.example.lab2android

class FavoritesRepository {

    fun getMixedList(): List<ListItem> = buildList {
        val books = listOf(
            Book(1, "Тіні забутих предків", "Михайло Коцюбинський", 120),
            Book(2, "1984", "Джордж Орвелл", 328),
            Book(3, "Гаррі Поттер", "Дж. К. Роулінг", 432),
            Book(4, "Кобзар", "Тарас Шевченко", 256),
            Book(5, "Маленький принц", "Антуан де Сент-Екзюпері", 96)
        )

        val movies = listOf(
            Movie(1, "Інтерстеллар", 2014, listOf("Sci-Fi", "Драма", "Пригоди")),
            Movie(2, "Темний лицар", 2008, listOf("Бойовик", "Кримінал")),
            Movie(3, "Форест Гамп", 1994, listOf("Драма", "Романтика")),
            Movie(4, "Початок", 2010, listOf("Sci-Fi", "Трилер")),
            Movie(5, "Матриця", 1999, listOf("Sci-Fi", "Бойовик"))
        )

        val carouselMovies = listOf(
            Movie(101, "Аватар", 2009, listOf("Sci-Fi", "Пригоди")),
            Movie(102, "Титанік", 1997, listOf("Драма", "Романтика")),
            Movie(103, "Месники", 2012, listOf("Бойовик", "Sci-Fi")),
            Movie(104, "Гладіатор", 2000, listOf("Бойовик", "Драма"))
        )

        add(ListItem.HeaderItem("Книги - Частина 1"))
        books.take(2).forEach { add(ListItem.BookItem(it)) }

        add(ListItem.HeaderItem("Рекомендовані фільми"))
        add(ListItem.MovieCarouselItem(carouselMovies))

        add(ListItem.HeaderItem("Всі фільми"))
        movies.forEach { add(ListItem.MovieItem(it)) }

        add(ListItem.HeaderItem("Книги - Частина 2"))
        books.drop(2).forEach { add(ListItem.BookItem(it)) }
    }
}