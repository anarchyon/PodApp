package project.paveltoy.podapp.ui.epic.colortype

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.paveltoy.podapp.data.entities.EpicDay
import project.paveltoy.podapp.databinding.ItemEpicBinding

class EpicDatesAdapter: RecyclerView.Adapter<EpicDatesAdapter.DatesViewHolder>() {
    var dates: List<EpicDay> = listOf()
    var callback: ((date: String) -> Unit)? = null

    inner class DatesViewHolder(private val binding: ItemEpicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(epicDay: EpicDay) {
            binding.epicDate.text = epicDay.date
            itemView.setOnClickListener {
                callback?.invoke(epicDay.date)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatesViewHolder {
        val binding = ItemEpicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DatesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DatesViewHolder, position: Int) {
        holder.bind(dates[position])
    }

    override fun getItemCount(): Int {
        return dates.size
    }
}