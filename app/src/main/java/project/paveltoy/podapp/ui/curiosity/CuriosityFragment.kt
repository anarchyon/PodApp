package project.paveltoy.podapp.ui.curiosity

import android.os.Bundle
import android.transition.Fade
import android.transition.Slide
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.transition.MaterialContainerTransform
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentCuriosityBinding
import project.paveltoy.podapp.ui.MOTION_DURATION_LONG

class CuriosityFragment: Fragment(R.layout.fragment_curiosity) {
    private val binding: FragmentCuriosityBinding by viewBinding(FragmentCuriosityBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterTransition = Slide().apply {
            slideEdge = Gravity.END
            duration = MOTION_DURATION_LONG
        }
        returnTransition = Slide().apply {
            duration = MOTION_DURATION_LONG
        }
        setTitle()
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.curiosity)
    }
}