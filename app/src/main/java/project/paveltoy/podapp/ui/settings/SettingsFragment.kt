package project.paveltoy.podapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment(R.layout.fragment_settings) {
    private val binding: FragmentSettingsBinding by viewBinding(FragmentSettingsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
        setChipsClickListener()
    }

    private fun setChipsClickListener() {
        binding.chipsThemes.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.purpleTheme.id -> {
                    setTheme(R.style.Theme_PodApp_Purple)
                }
                binding.blueGreyTheme.id -> {
                    setTheme(R.style.Theme_PodApp_BlueGrey)
                }
                binding.lightBlueTheme.id -> {
                    setTheme(R.style.Theme_PodApp_LightBlue)
                }
                binding.redTheme.id -> {
                    setTheme(R.style.Theme_PodApp_Red)
                }
            }
        }
    }

    private fun setTheme(themeId: Int) {
        requireActivity().apply {
            setTheme(themeId)
            recreate()
        }
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.settings)
    }
}