package project.paveltoy.podapp.ui.epic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentNaturalColorsBinding

class NaturalColorsFragment : Fragment(R.layout.fragment_natural_colors) {
    private val binding: FragmentNaturalColorsBinding by viewBinding(FragmentNaturalColorsBinding::bind)
    private val epicDatesAdapter = EpicDatesAdapter()
    private var viewModel: EpicViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initViewModel()
        viewModel?.loadEpicDatesNatural()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(EpicViewModel::class.java)
        viewModel?.naturalColorsLiveData?.observe(viewLifecycleOwner) {
            epicDatesAdapter.dates = it
            epicDatesAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        binding.naturalRecyclerView.apply {
            adapter = epicDatesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}