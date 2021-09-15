package project.paveltoy.podapp.ui

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.ActivityMainBinding
import project.paveltoy.podapp.utils.ThemesInfo

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)
    private lateinit var navController: NavController
    private lateinit var prefs: SharedPreferences
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        initViewModel()
        initTheme()

        super.onCreate(savedInstanceState)

        initNavigation()
        initToolbar()
        initFab()
    }

    private fun initFab() {
        binding.mainFab.setOnClickListener {
            navController.navigate(R.id.action_to_animation_fragment)
        }
    }

    private fun initTheme() {
        prefs = getSharedPreferences(ThemesInfo.THEMES_TAG, MODE_PRIVATE)
        if (prefs.contains(ThemesInfo.CURRENT_THEME_TAG)) {
            mainViewModel.currentTheme =
                prefs.getInt(ThemesInfo.CURRENT_THEME_TAG, ThemesInfo.STANDARD_THEME)
            setTheme(mainViewModel.getThemeId())
        }
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.setThemeCallback = this::applyTheme
    }

    private fun initToolbar() {
        setSupportActionBar(binding.topAppbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_settings -> {
                navController.navigate(R.id.action_to_settings_fragment)
            }
        }
        return true
    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNavigation.isVisible =
                destination.id !in listOf(
                    R.id.settings_fragment,
                    R.id.animation_fragment,
                    R.id.epic_image_fragment
                )

            when (destination.id) {
                R.id.curiosity_fragment -> {
                    binding.apply {
                        imageCuriosity.visibility = View.VISIBLE
                        collapsingToolbar.isTitleEnabled = true
                    }
                }
                else -> {
                    binding.apply {
                        imageCuriosity.visibility = View.GONE
                        collapsingToolbar.isTitleEnabled = false
                    }
                }
            }
        }
    }

    private fun applyTheme(theme: Int) {
        savePrefs(theme)
        recreate()
    }

    private fun savePrefs(theme: Int) {
        prefs.edit().putInt(ThemesInfo.CURRENT_THEME_TAG, theme).apply()
    }
}