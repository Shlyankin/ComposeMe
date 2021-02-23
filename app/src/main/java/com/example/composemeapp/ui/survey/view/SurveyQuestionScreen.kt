package com.example.composemeapp.ui.survey.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composemeapp.R
import com.example.composemeapp.data.Answer
import com.example.composemeapp.data.PossibleAnswer
import com.example.composemeapp.data.Question
import com.example.composemeapp.theme.grey
import com.example.composemeapp.theme.progressIndicatorBackground

@Preview
@Composable
fun SurveyQuestion(
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                SurveyBottomBarTitle(questionIndex = 0, totalQuestionsCount = 100)
            },
            bodyContent = {
                QuestionContent()
            },
            bottomBar = {
                SurveyBottomBar()
            }
        )
    }
}

@Preview
@Composable
fun QuestionContent(
    question: Question =
        Question(
            0,
            "Хелло, черти",
            description = "Как дела?",
            answer = PossibleAnswer.SingleChoice(
                listOf(
                    Answer(0, "Normas"),
                    Answer(1, "classno"),
                    Answer(2, "Super")
                )
            )
        )
) {
    LazyColumn(
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp)
    ) {
        item {
            Spacer(modifier = Modifier.preferredHeight(44.dp))
            val backgroundColor = if (MaterialTheme.colors.isLight) {
                MaterialTheme.colors.onSurface.copy(alpha = 0.04f)
            } else {
                MaterialTheme.colors.onSurface.copy(alpha = 0.06f)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = backgroundColor,
                        shape = MaterialTheme.shapes.small
                    )
            ) {
                Text(
                    text = question.questionText,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp, horizontal = 16.dp)
                )
            }
            Spacer(modifier = Modifier.preferredHeight(24.dp))
            if (question.description != null) {
                Providers(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = question.description,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp, start = 8.dp, end = 8.dp)
                    )
                }
            }
            when (question.answer) {
                is PossibleAnswer.SingleChoice -> {
                    SingleChoiceQuestion(
                        possibleAnswer = question.answer,
                        resultAnswer = null,
                        onAnswerSelected = {

                        })
                }
                is PossibleAnswer.MultipleChoice -> {

                }
                is PossibleAnswer.Action -> {

                }
                is PossibleAnswer.Slider -> {

                }
            }
        }
    }
}

@Preview
@Composable
fun SurveyBottomBar(
    onNextPressed: () -> Unit = {},
    onPrevPressed: () -> Unit = {}
) {
    Surface(elevation = 10.dp) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)
        ) {
            OutlinedButton(
                onClick = onPrevPressed,
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(id = R.string.prev))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = onNextPressed,
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(id = R.string.next))
            }
        }
    }
}

@Preview
@Composable
fun SurveyBottomBarTitle(
    questionIndex: Int = 1,
    totalQuestionsCount: Int = 100,
    onBackPressed: () -> Unit = {}
) {
    ConstraintLayout(modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp)) {
        val (button, text, progress) = createRefs()

        SurveyTitle(
            questionIndex = questionIndex,
            totalQuestionsCount = totalQuestionsCount,
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(parent.top, margin = 12.dp)
                    bottom.linkTo(progress.top, margin = 12.dp)
                    centerHorizontallyTo(parent)
                }
        )

        IconButton(
            onClick = onBackPressed,
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(parent.top, margin = 12.dp)
                    bottom.linkTo(progress.top, margin = 12.dp)
                    end.linkTo(parent.end)
                }.then(Modifier.preferredSize(24.dp))
        ) {
            Icon(
                Icons.Filled.Close,
                contentDescription = stringResource(id = R.string.close),
                tint = MaterialTheme.colors.grey
            )
        }

        LinearProgressIndicator(
            progress = (questionIndex + 1) / totalQuestionsCount.toFloat(),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(progress) {
                    bottom.linkTo(parent.bottom)
                },
            backgroundColor = MaterialTheme.colors.progressIndicatorBackground
        )
    }
}

@Preview
@Composable
fun SurveyTitle(
    modifier: Modifier = Modifier,
    questionIndex: Int = 1,
    totalQuestionsCount: Int = 100
) {
    val text = stringResource(
        R.string.question_count,
        questionIndex + 1, totalQuestionsCount
    )
    Text(
        text,
        style = MaterialTheme.typography.subtitle1,
        modifier = modifier
    )
}
