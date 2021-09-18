package project.paveltoy.podapp.utils

import androidx.navigation.NavController

class AppNavigator {
    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

}