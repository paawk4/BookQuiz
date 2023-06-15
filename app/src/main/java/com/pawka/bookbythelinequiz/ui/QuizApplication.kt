package com.pawka.bookbythelinequiz.ui

import android.app.Application
import com.pawka.bookbythelinequiz.di.ApplicationComponent
import com.pawka.bookbythelinequiz.di.DaggerApplicationComponent

class QuizApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}