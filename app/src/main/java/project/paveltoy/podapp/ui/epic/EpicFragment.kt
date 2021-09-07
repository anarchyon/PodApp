package project.paveltoy.podapp.ui.epic

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentEpicBinding
import project.paveltoy.podapp.ui.epic.colortype.EnhancedColorsFragment
import project.paveltoy.podapp.ui.epic.colortype.EpicAdapter
import project.paveltoy.podapp.ui.epic.colortype.NaturalColorsFragment

class EpicFragment : Fragment(R.layout.fragment_epic) {
    private val binding: FragmentEpicBinding by viewBinding(FragmentEpicBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
        setViewPager()
    }

    private fun setViewPager() {
        val adapter = EpicAdapter(this)
        adapter.fragmentSet = listOf(NaturalColorsFragment(), EnhancedColorsFragment())
        binding.epicColorsPager.let {
            it.adapter = adapter
            val tabLayoutMediator = TabLayoutMediator(
                binding.epicTabLayout,
                it
            ) { tab, position ->
                when(position) {
                    0 -> tab.text = getString(R.string.epic_natural)
                    1 -> tab.text = getString(R.string.epic_enhanced)
                }
            }
            tabLayoutMediator.attach()
        }
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.epic)
    }
}