package project.paveltoy.podapp.ui

import androidx.lifecycle.ViewModel
import project.paveltoy.podapp.R
import project.paveltoy.podapp.utils.ThemesInfo

class MainViewModel: ViewModel() {
    var currentTheme: Int = 0
    lateinit var setThemeCallback: (theme: Int) -> Unit

    fun getThemeId(): Int = when (currentTheme) {
        ThemesInfo.BLUE_GREY_THEME -> R.style.Theme_PodApp_BlueGrey
        ThemesInfo.LIGHT_BLUE_THEME -> R.style.Theme_PodApp_LightBlue
        ThemesInfo.RED_THEME -> R.style.Theme_PodApp_Red
        else -> R.style.Theme_PodApp_Purple
    }

    fun setTheme(theme: Int) {
        currentTheme = theme
        setThemeCallback.invoke(theme)
    }
}