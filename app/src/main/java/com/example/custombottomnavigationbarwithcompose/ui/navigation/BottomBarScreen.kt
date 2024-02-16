package com.example.custombottomnavigationbarwithcompose.ui.navigation
import com.example.custombottomnavigationbarwithcompose.R
sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val iconFocused: Int
) {

    // for home
    data object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.baseline_home_24,
        iconFocused = R.drawable.baseline_home_24
    )

    // for report
    data object Report: BottomBarScreen(
        route = "report",
        title = "Report",
        icon = R.drawable.baseline_report_24,
        iconFocused = R.drawable.baseline_report_24
    )

    // for report
    data object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.baseline_person_24,
        iconFocused = R.drawable.baseline_person_24
    )

}
