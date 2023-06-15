package com.pawka.bookbythelinequiz.data

import com.pawka.bookbythelinequiz.R
import com.pawka.bookbythelinequiz.domain.model.Book
import com.pawka.bookbythelinequiz.domain.repository.BookRepository
import javax.inject.Inject

class BookRepoImpl @Inject constructor() : BookRepository {

    private val booksList = mutableListOf(
        Book(
            0,
            "Мистер и миссис Дурслей, из дома №4 по Бирючинной улице, гордились тем, что они, спасибо преогромное, люди абсолютно нормальные.",
            R.drawable.book1,
        ),
        Book(
            1,
            "Алисе наскучило сидеть с сестрой без дела на берегу реки; разок-другой она заглянула в книжку, которую читала сестра, но там не было ни картинок, ни разговоров.",
            R.drawable.book2,
        ),
        Book(
            2,
            "Я открываю настежь окна. В комнату вливается поток свежего воздуха. В яснеющем голубоватом сумраке я всматриваюсь в этюды и наброски начатой мною картины.",
            R.drawable.book3,
        ),
        Book(
            3,
            "Старая леди опустила очки и взглянула поверх них, осматривая комнату, потом приподняла очки и взглянула из-под них. Сквозь очки она редко или никогда не смотрела на такую мелочь...",
            R.drawable.book4
        ),
        Book(
            4,
            "Вот уже три месяца, как командир бронедивизиона полковник Александров не был дома. Вероятно, он был на фронте.",
            R.drawable.book5,
        ),
        Book(
            5,
            "Eh bien, mon prince. Gênes et Lucques ne sont plus que des apanages, des поместья, de la famille Buonaparte.",
            R.drawable.book6,
        ),
        Book(
            6,
            "Все счастливые семьи похожи друг на друга, каждая несчастливая семья несчастлива по-своему.",
            R.drawable.book7,
        ),
        Book(
            7,
            "Рассказ у нас пойдет в особенности о хоббитах, и любознательный читатель многое узнает об их нравах и кое-что из их истории.",
            R.drawable.book8,
        ),
        Book(
            8,
            "Спали мы в бывшем спортзале. Лакированные половицы, на них круги и полосы – для игр, в которые здесь играли когда-то; баскетбольные кольца до сих пор на месте, только сеток нет.",
            R.drawable.book9,
        ),
        Book(
            9,
            "В больничном дворе стоит небольшой флигель, окруженный целым лесом репейника, крапивы и дикой конопли.",
            R.drawable.book10,
        )
    )

    override fun getBooks(): MutableList<Book> {
        return booksList
    }
}