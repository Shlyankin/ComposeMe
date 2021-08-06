package com.example.composemeapp.di

import com.example.composemeapp.ui.survey.SurveyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    // todo: write dependencies
}

val viewModels = module {
    viewModel {
        SurveyViewModel()
    }
}

val allModules = arrayOf(
    appModule
)