package project.paveltoy.podapp.ui.settings

import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.transition.MaterialContainerTransform
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentSettingsBinding
import project.paveltoy.podapp.ui.MOTION_DURATION_LONG
import project.paveltoy.podapp.ui.MainViewModel
import project.paveltoy.podapp.utils.ThemesInfo

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private val binding: FragmentSettingsBinding by viewBinding(FragmentSettingsBinding::bind)
    private lateinit var mainViewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterTransition = Slide().apply {
            slideEdge = Gravity.TOP
            duration = MOTION_DURATION_LONG
        }
        returnTransition = Slide().apply {
            slideEdge = Gravity.TOP
            duration = MOTION_DURATION_LONG
        }
        initViewModel()
        setTitle()
        readTheme()
        setChipsClickListener()
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    private fun readTheme() {
        binding.chipsThemes.check(
            when (mainViewModel.currentTheme) {
                ThemesInfo.RED_THEME -> binding.redTheme.id
                ThemesInfo.LIGHT_BLUE_THEME -> binding.lightBlueTheme.id
                ThemesInfo.BLUE_GREY_THEME -> binding.blueGreyTheme.id
                else -> binding.purpleTheme.id
            }
        )
    }

    private fun setChipsClickListener() {
        binding.chipsThemes.setOnCheckedChangeListener { _, _ ->
            mainViewModel.setTheme(
                when {
                    binding.blueGreyTheme.isChecked -> ThemesInfo.BLUE_GREY_THEME
                    binding.lightBlueTheme.isChecked -> ThemesInfo.LIGHT_BLUE_THEME
                    binding.redTheme.isChecked -> ThemesInfo.RED_THEME
                    else -> ThemesInfo.STANDARD_THEME
                }
            )
        }
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.settings)
    }
}