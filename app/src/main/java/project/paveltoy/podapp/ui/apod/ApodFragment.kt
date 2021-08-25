package project.paveltoy.podapp.ui.apod

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import project.paveltoy.podapp.databinding.FragmentApodBinding

class ApodFragment: Fragment() {
    private var _binding: FragmentApodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentApodBinding.inflate(inflater, container,false)
        return binding.root
    }



    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}