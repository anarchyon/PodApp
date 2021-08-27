package project.paveltoy.podapp.ui.epic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentEpicBinding

class EpicFragment: Fragment() {
    private var _binding: FragmentEpicBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEpicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.epic)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}