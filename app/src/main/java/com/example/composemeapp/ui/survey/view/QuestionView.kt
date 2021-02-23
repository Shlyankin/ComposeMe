package com.example.composemeapp.ui.survey.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composemeapp.data.Answer
import com.example.composemeapp.data.ResultAnswer
import com.example.composemeapp.data.PossibleAnswer

@Composable
fun SingleChoiceQuestion(
    possibleAnswer: PossibleAnswer.SingleChoice,
    resultAnswer: ResultAnswer.SingleChoice?,
    onAnswerSelected: (Answer) -> Unit,
    modifier: Modifier = Modifier
) {
    val options = possibleAnswer.optionsString
    val (selectedOption, onOptionSelected) = remember(resultAnswer) { mutableStateOf(resultAnswer?.answer) }
    Column(modifier) {
        options.forEach { answer ->
            val onClickHandle = {
                onOptionSelected(answer)
                onAnswerSelected(answer)
            }
            val optionSelected = answer == resultAnswer?.answer
            Surface(
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = optionSelected,
                            onClick = onClickHandle
                        )
                        .padding(vertical = 16.dp, horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = answer.answerText)

                    RadioButton(
                        selected = optionSelected,
                        onClick = onClickHandle,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colors.primary
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun MultipleChoiceQuestion() {

}

@Composable
fun ActionQuestion() {

}

@Composable
fun SliderQuestion() {

}