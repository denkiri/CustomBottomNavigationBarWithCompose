# CustomBottomNavigationBarWithCompose
This example demonstrates how to make a Custom Jetpack Compose Bottom Navigation Bar.
# Why is the navigation bar important in an app?
1. allow users to access the most important features of the app that they would need to use frequently
2. It makes the user aware of the different screens available in the app.
3. The user can check which screen are they on at the moment.
4. The Navigation Bar should be used for Three to five destinations
# Navigation bars shouldn’t be used for:
1. Single tasks, such as viewing a single email
2. User preferences or settings
3. Medium to extra-large window sizes
# Material Design badge box.
A badge represents dynamic information such as a number of pending requests in a navigation bar
# Implementation  

   
# Dependencies 
implementation 'androidx.navigation:navigation-compose:2.7.7'
# overview
To link the items in a bottom navigation bar to routes in your navigation graph, it is recommended to define a [sealed class](https://github.com/denkiri/CustomBottomNavigationBarWithCompose/blob/master/app/src/main/java/com/example/custombottomnavigationbarwithcompose/ui/navigation/BottomBarScreen.kt) that contains the route and String resource ID for the destinations.
Then place those items in a list that can be used by the [BottomNavigationItem](https://github.com/denkiri/CustomBottomNavigationBarWithCompose/blob/master/app/src/main/java/com/example/custombottomnavigationbarwithcompose/ui/navigation/BottomNav.kt):
```
 val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Report,
        BottomBarScreen.Profile
    )
```
In your BottomNavigation composable, get the current NavBackStackEntry using the currentBackStackEntryAsState() function. This entry gives you access to the current NavDestination.
```
val navStackBackEntry by navController.currentBackStackEntryAsState()
val currentDestination = navStackBackEntry?.destination
```
#References
https://developer.android.com/jetpack/compose/navigation#kts
https://www.boltuix.com/2022/08/custom-bottom-navigation-bar.html

# Screenshots
<img src="https://github.com/denkiri/CustomBottomNavigationBarWithCompose/blob/master/Screenshot_20240216_050533.png" width="250" height="540">|<img src="https://github.com/denkiri/CustomBottomNavigationBarWithCompose/blob/master/Screenshot_20240216_050556.png" width="250" height="540">

<img src="https://github.com/denkiri/CustomBottomNavigationBarWithCompose/blob/master/Screenshot_20240216_050722.png" width="250" height="540">|<img src="https://github.com/denkiri/CustomBottomNavigationBarWithCompose/blob/master/Screenshot_20240216_082759.png" width="250" height="540">
<img src="https://github.com/denkiri/CustomBottomNavigationBarWithCompose/blob/master/Screenshot_20240216_082909.png" width="250" height="540">

   

