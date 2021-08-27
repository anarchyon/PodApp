package project.paveltoy.podapp.ui.apod

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import project.paveltoy.podapp.R
import project.paveltoy.podapp.data.entities.Apod
import project.paveltoy.podapp.databinding.FragmentApodBinding
import java.text.SimpleDateFormat
import java.util.*

private const val DATE_FORMAT = "yyyy-MM-dd"

class ApodFragment : Fragment() {
    private var _binding: FragmentApodBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ApodViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentApodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
        initViewModel()
        setChipsListener()
        binding.chipsApod.check(binding.todayApod.id)
    }

    private fun setChipsListener() {
        binding.chipsApod.setOnCheckedChangeListener { _, checkedId ->
            val calendar = Calendar.getInstance()
            when (checkedId) {
                binding.beforeYesterdayApod.id -> {
                    calendar.add(Calendar.DAY_OF_MONTH, -2)
                }
                binding.yesterdayApod.id -> {
                    calendar.add(Calendar.DAY_OF_MONTH, -1)
                }
            }
            val date = calendar.time
            getApod(getDateInString(date))
        }
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.apod)
    }

    private fun getDateInString(date: Date): String {
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(date)
    }

    private fun getApod(date: String) {
        viewModel.getApod(date)
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

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}