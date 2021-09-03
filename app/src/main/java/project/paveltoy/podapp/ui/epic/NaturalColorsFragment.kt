package project.paveltoy.podapp.ui.epic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentNaturalColorsBinding

class NaturalColorsFragment : Fragment(R.layout.fragment_natural_colors) {
    private val binding: FragmentNaturalColorsBinding by viewBinding(FragmentNaturalColorsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = EpicDatesAdapter()
        binding.naturalRecyclerView.adapter = adapter
    }
}