package com.pawka.bookbythelinequiz.domain.use_case

import com.pawka.bookbythelinequiz.domain.model.Book
import com.pawka.bookbythelinequiz.domain.repository.BookRepository
import javax.inject.Inject

class GetAllBooksUseCase @Inject constructor(
    private val booksRepository: BookRepository
) {

    fun getAllBooks(): MutableList<Book> {
        return booksRepository.getBooks()
    }
}