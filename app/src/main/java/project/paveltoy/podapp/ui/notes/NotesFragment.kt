package project.paveltoy.podapp.ui.notes

import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Transition
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.transition.MaterialContainerTransform
import project.paveltoy.podapp.R
import project.paveltoy.podapp.databinding.FragmentNotesBinding
import project.paveltoy.podapp.ui.MOTION_DURATION_LONG
import project.paveltoy.podapp.ui.MainViewModel

class NotesFragment: Fragment(R.layout.fragment_notes) {
    private val binding: FragmentNotesBinding by viewBinding(FragmentNotesBinding::bind)
    private lateinit var notesRecyclerView: RecyclerView
    private val notesAdapter = NotesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterTransition = androidx.transition.Slide().apply {
            slideEdge = Gravity.TOP
            duration = MOTION_DURATION_LONG
        }
        returnTransition = androidx.transition.Slide().apply {
            slideEdge = Gravity.TOP
            duration = MOTION_DURATION_LONG
        }
        setTitle()
        initRecyclerView()
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.notes)
    }

    private fun initRecyclerView() {
        notesRecyclerView = binding.notesRecyclerView
        notesRecyclerView.adapter = notesAdapter
    }
}