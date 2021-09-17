package project.paveltoy.podapp.ui.apod

import android.os.Bundle
import android.transition.*
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.view.ViewGroup
import android.widget.ImageView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.transition.MaterialContainerTransform
import com.squareup.picasso.Picasso
import project.paveltoy.podapp.R
import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.databinding.FragmentApodBinding
import project.paveltoy.podapp.ui.MOTION_DURATION_LONG
import java.text.SimpleDateFormat
import java.util.*

private const val OFFSET_FOR_BEFORE_YESTERDAY = -2
private const val OFFSET_FOR_YESTERDAY = -1
private const val OFFSET_FOR_TODAY = 0

class ApodFragment : Fragment(R.layout.fragment_apod) {
    private val binding: FragmentApodBinding by viewBinding(FragmentApodBinding::bind)
    private lateinit var viewModel: ApodViewModel
    private var isImageExpanded = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterTransition = Slide().apply {
            slideEdge = Gravity.END
            duration = MOTION_DURATION_LONG
        }
        setTitle()
        initViewModel()
        setChipsListener()
        binding.chipsApod.check(binding.todayApod.id)
    }

    private fun setChipsListener() {
        binding.chipsApod.setOnCheckedChangeListener { _, checkedId ->
            viewModel.loadApod(
                when (checkedId) {
                    binding.beforeYesterdayApod.id -> OFFSET_FOR_BEFORE_YESTERDAY
                    binding.yesterdayApod.id -> OFFSET_FOR_YESTERDAY
                    else -> OFFSET_FOR_TODAY
                }
            )
        }
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.apod)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(ApodViewModel::class.java)
        viewModel.apodLiveData.let { it ->
            it.observe(viewLifecycleOwner) { showApod(it) }
        }
    }

    private fun showApod(apod: Apod) {
        binding.apply {
            Picasso.get().load(apod.url).into(apodImage)
            apodExplanation.text = apod.explanation
        }
    }
}