package project.paveltoy.podapp.ui.epic.colortype

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentNaturalColorsBinding
import project.paveltoy.podapp.ui.epic.EpicViewModel

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
        viewModel = ViewModelProvider(requireActivity()).get(EpicViewModel::class.java)
        viewModel?.naturalColorsLiveData?.observe(viewLifecycleOwner) {
            epicDatesAdapter.dates = it
            epicDatesAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        binding.naturalRecyclerView.apply {
            adapter = epicDatesAdapter
            epicDatesAdapter.callback = this@NaturalColorsFragment::epicDateClickListener
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun epicDateClickListener(date: String) {
        val epicCardImage = getString(R.string.epic_card_image)
        val epicCard = requireActivity().findViewById<ViewGroup>(R.id.epic_card_view)
        val extras = FragmentNavigatorExtras(epicCard to epicCardImage)
        val directions: NavDirections = NaturalColorsFragmentDirections.actionToEpicImageFragment()
        findNavController().navigate(directions, extras)
        viewModel?.loadEpicNaturalImages(date)
    }
}