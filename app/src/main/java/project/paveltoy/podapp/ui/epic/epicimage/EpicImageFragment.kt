package project.paveltoy.podapp.ui.epic.epicimage

import android.os.Bundle
import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.TransitionSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.transition.TransitionManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.transition.MaterialContainerTransform
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentEpicImageBinding
import project.paveltoy.podapp.ui.MOTION_DURATION_LONG
import project.paveltoy.podapp.ui.epic.EpicViewModel

class EpicImageFragment : Fragment(R.layout.fragment_epic_image) {
    val binding: FragmentEpicImageBinding by viewBinding(FragmentEpicImageBinding::bind)
    var imageAdapter: EpicImageAdapter? = null
    var viewModel: EpicViewModel? = null
    var isImageEnlarged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.fragment_container
            duration = MOTION_DURATION_LONG
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity()).get(EpicViewModel::class.java)
        viewModel?.epicImageLiveData?.observe(viewLifecycleOwner) {
            imageAdapter?.imageData = it
            imageAdapter?.notifyDataSetChanged()
        }
    }

    private fun setViewPager() {
        imageAdapter = EpicImageAdapter()
        imageAdapter?.onClickListener = this::enlargeImage
        binding.imagePager.adapter = imageAdapter
    }

    private fun enlargeImage() {
        isImageEnlarged = !isImageEnlarged
        val container = requireActivity().findViewById<FrameLayout>(R.id.image_container)
        TransitionManager.beginDelayedTransition(
            container, TransitionSet()
                .addTransition(ChangeBounds())
                .addTransition(ChangeImageTransform())
        )
        requireActivity().findViewById<ImageView>(R.id.epic_image_view).let {
            val params = it.layoutParams

                if (isImageEnlarged) {
                    params.height = ViewGroup.LayoutParams.MATCH_PARENT
                    it.scaleType = ImageView.ScaleType.CENTER_CROP
                } else {
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT
                    it.scaleType = ImageView.ScaleType.FIT_CENTER
                }
            it.layoutParams = params
        }
    }
}