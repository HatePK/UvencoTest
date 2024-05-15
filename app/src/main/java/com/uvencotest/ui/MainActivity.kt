package com.uvencotest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uvencotest.ui.screens.detailsScreen.RenderDetails
import com.uvencotest.ui.screens.mainScreen.RenderMainScreen
import com.uvencotest.ui.screens.topBar.TopBar
import com.uvencotest.ui.theme.background
import com.uvencotest.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            Column {
                TopBar(viewModel, navController)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(background)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "main_screen"
                    ) {
                        composable("main_screen") {
                            RenderMainScreen(viewModel)
                        }
                        composable("details_screen") {
                            RenderDetails(viewModel, navController)
                        }
                    }
                }
            }
        }
    }
}
