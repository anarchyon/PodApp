package project.paveltoy.podapp.ui.curiosity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentCuriosityBinding

class CuriosityFragment: Fragment(R.layout.fragment_curiosity) {
    private val binding: FragmentCuriosityBinding by viewBinding(FragmentCuriosityBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle()
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.curiosity)
    }
}