package project.paveltoy.podapp.ui.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import project.paveltoy.podapp.data.entities.Note
import project.paveltoy.podapp.databinding.ItemNoteBinding
import project.paveltoy.podapp.databinding.ItemNoteWithImageBinding

private const val TYPE_NOTE_TEXT_NOTE = 0
private const val TYPE_NOTE_WITH_IMAGE = 1

class NotesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperAdapter {
    var notesDataSet: List<Note> = arrayListOf()
    var onClickListener: ((note: Note) -> Unit)? = null
    var onItemMoveListener: ((thisNote: Note, beforeNote: Note) -> Unit)? = null
    var onSwipeListener: ((note: Note) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_NOTE_TEXT_NOTE -> {
                val binding: ItemNoteBinding =
                    ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                NoteViewHolder(binding)
            }
            else -> {
                val binding: ItemNoteWithImageBinding = ItemNoteWithImageBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                NoteWithImageViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_NOTE_TEXT_NOTE -> {
                (holder as NoteViewHolder).bind(notesDataSet[position])
            }
            TYPE_NOTE_WITH_IMAGE -> {
                (holder as NoteWithImageViewHolder).bind(notesDataSet[position])
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (notesDataSet[position].image.isNullOrEmpty()) TYPE_NOTE_TEXT_NOTE else TYPE_NOTE_WITH_IMAGE
    }

    override fun getItemCount(): Int = notesDataSet.size

    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.apply {
                noteTitle.text = note.title
                noteText.text = note.text
            }
            itemView.setOnClickListener {
                onClickListener?.invoke(note)
            }
        }
    }

    inner class NoteWithImageViewHolder(private val binding: ItemNoteWithImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.apply {
                noteTitle.text = note.title
                noteText.text = note.text
                Picasso.get().load(note.image).into(binding.noteImage)
            }
            itemView.setOnClickListener {
                onClickListener?.invoke(note)
            }
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        onItemMoveListener?.invoke(notesDataSet[fromPosition], notesDataSet[toPosition])
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemSwipe(position: Int) {
        onSwipeListener?.invoke(notesDataSet[position])
        notifyItemRemoved(position)
    }
}