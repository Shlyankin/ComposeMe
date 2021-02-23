package com.example.composemeapp.data

import android.net.Uri
import androidx.annotation.StringRes

data class SurveyResult(
    val library: String,
    val result: String,
    val description: String
)

data class Survey(
    val title: String,
    val questions: List<Question>
)

data class Question(
    val id: Int,
    val questionText: String,
    val answer: PossibleAnswer,
    val description: String? = null
)

data class Answer(
    val id: Int,
    val answerText: String
)

enum class SurveyActionType { PICK_DATE, TAKE_PHOTO, SELECT_CONTACT }

sealed class SurveyActionResult {
    data class Date(val date: String) : SurveyActionResult()
    data class Photo(val uri: Uri) : SurveyActionResult()
    data class Contact(val contact: String) : SurveyActionResult()
}

sealed class PossibleAnswer {
    data class SingleChoice(val optionsString: List<Answer>) : PossibleAnswer()
    data class MultipleChoice(val optionsString: List<Answer>) : PossibleAnswer()
    data class Action(
        val label: String,
        val actionType: SurveyActionType
    ) : PossibleAnswer()

    data class Slider(
        val range: ClosedFloatingPointRange<Float>,
        val steps: Int,
        val startText: String,
        val endText: String,
        val defaultValue: Float = range.start
    ) : PossibleAnswer()
}

sealed class ResultAnswer<T : PossibleAnswer> {
    data class SingleChoice(val answer: Answer) : ResultAnswer<PossibleAnswer.SingleChoice>()
    data class MultipleChoice(val answers: Set<Answer>) :
        ResultAnswer<PossibleAnswer.MultipleChoice>()

    data class Action(val result: SurveyActionResult) : ResultAnswer<PossibleAnswer.Action>()
    data class Slider(val answerValue: Float) : ResultAnswer<PossibleAnswer.Slider>()
}

fun ResultAnswer.MultipleChoice.withAnswerSelected(
    answer: Answer,
    selected: Boolean
): ResultAnswer.MultipleChoice {
    val newStringRes = answers.toMutableSet()
    if (!selected) {
        newStringRes.remove(answer)
    } else {
        newStringRes.add(answer)
    }
    return ResultAnswer.MultipleChoice(newStringRes)
}
