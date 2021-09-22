package project.paveltoy.podapp.ui.notes

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import project.paveltoy.podapp.R
import project.paveltoy.podapp.data.entities.Note
import project.paveltoy.podapp.databinding.FragmentNotesBinding
import project.paveltoy.podapp.ui.MOTION_DURATION_LONG

class NotesFragment: Fragment(R.layout.fragment_notes) {
    private val binding: FragmentNotesBinding by viewBinding(FragmentNotesBinding::bind)
    private lateinit var notesRecyclerView: RecyclerView
    private val notesAdapter = NotesAdapter()
    private var notesViewModel: NotesViewModel? = null

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
        initViewModel()
        setTitle()
        initRecyclerView()
        setFabClickListener()
    }

    private fun initViewModel() {
        notesViewModel = ViewModelProvider(requireActivity()).get(NotesViewModel::class.java)
        notesViewModel?.noteListLiveData?.observe(viewLifecycleOwner) {
            notesAdapter.notesDataSet = it
        }
        notesViewModel?.savedNotePositionLiveData?.observe(viewLifecycleOwner, this::moveToSavedNote)
    }

    private fun setFabClickListener() {
        binding.noteFab.setOnClickListener {
            notesViewModel?.cleanSelect()
            findNavController().navigate(R.id.action_to_note_fragment)
        }
    }

    private fun setTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            getString(R.string.notes)
    }

    private fun initRecyclerView() {
        notesRecyclerView = binding.notesRecyclerView
        notesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        notesRecyclerView.adapter = notesAdapter
        notesAdapter.apply {
            onClickListener = this@NotesFragment::openNote
            onItemMoveListener = this@NotesFragment::itemMove
            onSwipeListener = this@NotesFragment::swipeNote
        }
        notesViewModel?.loadNotes()?.let {
            notesAdapter.notesDataSet = it
        }
        val itemSwipeCallback = ItemSwipeCallback(notesAdapter)
        val itemTouchHelper = ItemTouchHelper(itemSwipeCallback)
        itemTouchHelper.attachToRecyclerView(notesRecyclerView)
    }

    private fun itemMove(thisNote: Note, beforeNote: Note) {
        notesViewModel?.swapNotes(thisNote, beforeNote)
    }

    private fun swipeNote(note: Note) {
        notesViewModel?.deleteNote(note)
    }

    private fun openNote(note: Note) {
        notesViewModel?.setSelectedNote(note)
        findNavController().navigate(R.id.action_to_note_fragment)
    }

    private fun moveToSavedNote(position: Int) {
        notesAdapter.notifyItemInserted(position)
    }
}