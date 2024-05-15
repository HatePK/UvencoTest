package com.uvencotest.ui.screens.mainScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.uvencotest.ui.viewModel.MainState
import com.uvencotest.ui.viewModel.MainViewModel

@Composable
fun RenderMainScreen(viewModel: MainViewModel) {
    val state: MainState by viewModel.stateLiveData.collectAsState()

    when (state) {
        is MainState.Loading -> RenderLoading()
        is MainState.Content -> RenderContent((state as MainState.Content).products)
    }
}