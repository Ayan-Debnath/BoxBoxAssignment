package com.ayan.boxboxassignmnet.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ayan.boxboxassignmnet.ui.screens.HomeScreen
import com.ayan.boxboxassignmnet.ui.theme.BoxBoxAssignmnetTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BoxBoxAssignmnetTheme {
                HomeScreen()
            }
        }
    }
}
