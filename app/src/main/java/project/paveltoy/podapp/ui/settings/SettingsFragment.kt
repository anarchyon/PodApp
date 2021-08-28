package project.paveltoy.podapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

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

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}