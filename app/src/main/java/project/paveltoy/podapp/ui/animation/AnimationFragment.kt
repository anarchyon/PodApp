package project.paveltoy.podapp.ui.animation

import android.os.Bundle
import android.transition.Explode
import android.transition.Fade
import android.transition.Visibility
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentAnimationBinding
import project.paveltoy.podapp.ui.MOTION_DURATION_LONG

class AnimationFragment : Fragment(R.layout.fragment_animation) {
    private val binding: FragmentAnimationBinding by viewBinding(FragmentAnimationBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterTransition = Fade().apply {
            mode = Visibility.MODE_IN
            duration = MOTION_DURATION_LONG
        }
        returnTransition = Fade().apply {
            mode = Visibility.MODE_OUT
            duration = MOTION_DURATION_LONG
        }
    }
}