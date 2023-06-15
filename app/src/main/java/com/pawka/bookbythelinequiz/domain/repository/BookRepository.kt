package com.pawka.bookbythelinequiz.domain.repository

import com.pawka.bookbythelinequiz.domain.model.Book

interface BookRepository {
    fun getBooks(): MutableList<Book>
}