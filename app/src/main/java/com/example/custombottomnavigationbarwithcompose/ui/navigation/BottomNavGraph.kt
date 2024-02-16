package com.example.custombottomnavigationbarwithcompose.ui.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.custombottomnavigationbarwithcompose.ui.screens.HomeScreen
import com.example.custombottomnavigationbarwithcompose.ui.screens.ProfileScreen
import com.example.custombottomnavigationbarwithcompose.ui.screens.ReportScreen
@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Report.route) {
            ReportScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
    }
}
