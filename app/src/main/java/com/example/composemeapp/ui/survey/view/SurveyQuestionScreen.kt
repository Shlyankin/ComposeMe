package com.example.composemeapp.ui.survey.view

import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composemeapp.theme.progressIndicatorBackground

@Preview
@Composable
fun SurveyQuestion(
) {

    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                SurveyTopBarTitle(questionIndex = 0, totalQuestionsCount = 1)
            },
            bodyContent = {

            },
            bottomBar = {

            }
        )
    }

}

@Preview
@Composable
fun SurveyTopBarTitle(
    questionIndex: Int = 1,
    totalQuestionsCount: Int = 100,
    onBackPressed: () -> Unit = {}
) {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (button, text, progress) = createRefs()
        TopAppBarTitle(questionIndex = questionIndex, totalQuestionsCount = totalQuestionsCount,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .constrainAs(text) { centerHorizontallyTo(parent) })


        Providers(LocalContentAlpha provides ContentAlpha.medium) {
            IconButton(
                onClick = onBackPressed,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .constrainAs(button) { end.linkTo(parent.end) }
            ) {
                Icon(
                    Icons.Filled.Close,
                    contentDescription = stringResource(id = R.string.abc_action_bar_home_description)
                )
            }
        }

        LinearProgressIndicator(
            progress = (questionIndex + 1) / totalQuestionsCount.toFloat(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .constrainAs(progress) {
                    bottom.linkTo(text.bottom)
                },
            backgroundColor = MaterialTheme.colors.progressIndicatorBackground
        )
    }
}

@Composable
fun TopAppBarTitle(
    questionIndex: Int,
    totalQuestionsCount: Int,
    modifier: Modifier
) {

}
