package com.example.composemeapp.ui.survey.view

import androidx.annotation.StringRes
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.composemeapp.data.ResultAnswer
import com.example.composemeapp.data.Question
import com.example.composemeapp.data.SurveyResult


@Stable
class QuestionState(
    val question: Question,
    val questionIndex: Int,
    val totalQuestionsCount: Int,
    val showPrevious: Boolean,
    val showDone: Boolean
) {
    var enableNext by mutableStateOf(false)
    var answer by mutableStateOf<ResultAnswer<*>?>(null)
}


sealed class SurveyState {
    data class Question(
        @StringRes val surveyTitle: Int,
        val questionsState: List<QuestionState>
    ) : SurveyState() {
        var currentQuestionIndex by mutableStateOf(0)
    }
    data class Result(
        @StringRes val surveyTitle: Int,
        val surveyResult: SurveyResult
    ) : SurveyState()
}