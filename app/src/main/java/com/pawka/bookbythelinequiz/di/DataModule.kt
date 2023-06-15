package com.pawka.bookbythelinequiz.di

import com.pawka.bookbythelinequiz.data.BookRepoImpl
import com.pawka.bookbythelinequiz.domain.repository.BookRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: BookRepoImpl): BookRepository

}