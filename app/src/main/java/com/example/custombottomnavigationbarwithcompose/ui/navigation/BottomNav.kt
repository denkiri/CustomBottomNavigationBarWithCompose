package com.example.custombottomnavigationbarwithcompose.ui.navigation
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.custombottomnavigationbarwithcompose.ui.theme.Green80
import com.example.custombottomnavigationbarwithcompose.ui.theme.GreenGrey80

@Composable
fun BottomNav() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        Modifier.padding(it)
        BottomNavGraph(
            navController = navController
        )
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Report,
        BottomBarScreen.Profile
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 12.dp, bottom = 10.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    val background =
        if (selected) Green80.copy(alpha = 0.6f) else GreenGrey80
        if (selected) Color.White else Color.White

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {


            //* if menu title : Report means we will show badge
            if(screen.title=="Report"){ // with badge
                BadgedBox(badge = { Badge( containerColor=Color.White) { Text("6", color = Color.Red) } }) {
                    Icon(
                        painter = painterResource(id = if (selected) screen.iconFocused else screen.icon),
                        contentDescription = "icon",
                        tint = Color.White
                    )
                }

            }
            else{

                Icon(
                    painter = painterResource(id = if (selected) screen.iconFocused else screen.icon),
                    contentDescription = "icon",
                    tint = Color.White
                )

            }






            AnimatedVisibility(visible = selected) {
                Text(
                    text = screen.title,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
@Preview
fun BottomNavPreview() {
    BottomNav()
}