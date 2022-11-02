package com.example.presentation.ui.more

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun MoreScreen(
    navController: NavController,
    moreViewModel: MoreViewModel = hiltViewModel()
) {
    val user by moreViewModel.user.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(user?.token?: "null")
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Back")
        }
    }
}