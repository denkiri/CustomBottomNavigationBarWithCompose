package com.example.custombottomnavigationbarwithcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
@Composable
fun ReportScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Report Screen", fontSize = 20.sp)
    }
}