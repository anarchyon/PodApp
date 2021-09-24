package project.paveltoy.podapp.ui.notes.note

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import project.paveltoy.podapp.R
import project.paveltoy.podapp.data.entities.Note
import project.paveltoy.podapp.databinding.FragmentNoteBinding
import project.paveltoy.podapp.ui.notes.NotesViewModel

class NoteFragment : Fragment(R.layout.fragment_note) {
    private val binding: FragmentNoteBinding by viewBinding(FragmentNoteBinding::bind)
    private var viewModel: NotesViewModel? = null
    private var note: Note? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initFab()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity()).get(NotesViewModel::class.java)
        viewModel?.selectedNoteLiveData?.observe(viewLifecycleOwner) {
            if (it != null) {
                note = it
                binding.apply {
                    noteFragmentText.editText?.setText(it.text)
                    noteFragmentTitle.editText?.setText(it.title)
                }
            } else note = null
        }
    }

    private fun initFab() {
        binding.saveFab.setOnClickListener {
            when {
                binding.noteFragmentTitle.editText?.text.isNullOrBlank() -> {
                    view?.showLongtimeSnackbar(getString(R.string.title_is_empty), binding.saveFab)
                }
                binding.noteFragmentText.editText?.text.isNullOrBlank() -> {
                    view?.showLongtimeSnackbar(getString(R.string.text_is_empty), binding.saveFab)
                }
                else -> {
                    prepareNoteToSave()
                    viewModel?.saveNote(note!!)
                    view?.showLongtimeSnackbar(getString(R.string.saving_note), binding.saveFab)
                    requireActivity().onBackPressed()
                }
            }
        }
    }

    fun prepareNoteToSave() {
        val title = binding.noteFragmentTitle.editText?.text.toString()
        val text = binding.noteFragmentText.editText?.text.toString()
        note = if (note == null) {
            Note(title, text)
        } else {
            Note(title, text, id = note!!.id)
        }
    }
}

fun View.showLongtimeSnackbar(text: String, anchorView: View?) {
    Snackbar
        .make(this.context, this, text, Snackbar.LENGTH_LONG)
        .setAnchorView(anchorView)
        .show()
}
