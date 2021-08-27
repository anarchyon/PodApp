package project.paveltoy.podapp.ui.donki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentDonkiBinding

class DonkiFragment: Fragment() {
    private var _binding: FragmentDonkiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDonkiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.donki)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}