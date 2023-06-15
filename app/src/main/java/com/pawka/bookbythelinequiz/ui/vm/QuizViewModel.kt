package com.pawka.bookbythelinequiz.ui.vm

import androidx.compose.ui.focus.FocusManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pawka.bookbythelinequiz.domain.model.Book
import com.pawka.bookbythelinequiz.domain.model.ResultBook
import com.pawka.bookbythelinequiz.domain.use_case.GetAllBooksUseCase
import javax.inject.Inject

class QuizViewModel @Inject constructor(
    private val getAllBooksUseCase: GetAllBooksUseCase
) : ViewModel() {

    var booksList = mutableListOf<Book>()

    val selectedBookId = MutableLiveData<Int>()

    private val _randomBooks = MutableLiveData<List<Book>>()
    val randomBooks: LiveData<List<Book>> = _randomBooks

    private val _rightAnswer = MutableLiveData<Book>()
    val rightAnswer: LiveData<Book> = _rightAnswer

    val resultList = mutableListOf<ResultBook>()

    private lateinit var focusManager: FocusManager

    fun setFocusManager(focus: FocusManager) {
        focusManager = focus
    }

    private fun clearFocusManager() {
        focusManager.clearFocus()
    }

    fun getBooks() {
        booksList = getAllBooksUseCase.getAllBooks()
    }

    fun getThreeRandomBooks() {
        _randomBooks.value = takeRandomItems(booksList)
        _rightAnswer.value = _randomBooks.value?.random()!!
    }

    fun getNewRandomBooks(navigateNext: () -> Unit) {
        clearFocusManager()
        val selectedItem = booksList.find { it.id == selectedBookId.value}!!
        val item = ResultBook(_rightAnswer.value?.image!!, selectedItem.image)
        resultList.add(item)

        booksList.removeIf { i -> _randomBooks.value?.contains(i)!! }
        if (booksList.size < 3) {
            navigateNext()
        } else {
            selectedBookId.value = UNSELECTED_ITEM
            getThreeRandomBooks()
        }
    }

    private fun takeRandomItems(quizList: MutableList<Book>): List<Book> =
        quizList.asSequence().shuffled().take(3).toList()

    companion object {
        const val UNSELECTED_ITEM = -1
    }
}