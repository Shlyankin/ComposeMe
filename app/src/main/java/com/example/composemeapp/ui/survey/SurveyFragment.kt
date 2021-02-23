package com.example.composemeapp.ui.survey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.composemeapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class SurveyFragment: Fragment() {

    private val viewModel: SurveyViewModel by viewModel<SurveyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            id = R.id.survey_fragment
            layoutParams =ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            setContent {

            }
        }
    }
}