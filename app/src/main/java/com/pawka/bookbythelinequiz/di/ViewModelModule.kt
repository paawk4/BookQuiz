package com.pawka.bookbythelinequiz.di

import androidx.lifecycle.ViewModel
import com.pawka.bookbythelinequiz.ui.vm.QuizViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(QuizViewModel::class)
    @Binds
    fun bindQuizViewModel(viewModel: QuizViewModel): ViewModel
}