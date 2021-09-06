package project.paveltoy.podapp.ui.epic.epicimage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentEpicImageBinding
import project.paveltoy.podapp.ui.epic.EpicViewModel

class EpicImageFragment: Fragment(R.layout.fragment_epic_image) {
    val binding: FragmentEpicImageBinding by viewBinding(FragmentEpicImageBinding::bind)
    var imageAdapter: EpicImageAdapter? = null
    var viewModel: EpicViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(EpicViewModel::class.java)
        viewModel
    }

    private fun setViewPager() {
        imageAdapter = EpicImageAdapter()
        binding.imagePager.let {
            it.adapter = imageAdapter
        }
    }
}