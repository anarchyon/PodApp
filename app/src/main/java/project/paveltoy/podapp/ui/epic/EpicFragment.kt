package project.paveltoy.podapp.ui.epic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentEpicBinding

class EpicFragment: Fragment(R.layout.fragment_epic) {
    private val binding: FragmentEpicBinding by viewBinding(FragmentEpicBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
        setViewPager()
    }

    private fun setViewPager() {
        val adapter = EpicAdapter(this)
        adapter.fragmentSet = listOf(NaturalColorsFragment(), EnhancedColorsFragment())
        binding.epicColorsPager.adapter = adapter
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.epic)
    }
}