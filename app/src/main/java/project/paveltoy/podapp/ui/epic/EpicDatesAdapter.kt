package project.paveltoy.podapp.ui.epic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.paveltoy.podapp.data.entities.EpicDay
import project.paveltoy.podapp.databinding.ItemEpicBinding

class EpicDatesAdapter: RecyclerView.Adapter<EpicDatesAdapter.DatesViewHolder>() {
    var dates: List<EpicDay> = listOf()

    class DatesViewHolder(private val binding: ItemEpicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(epicDay: EpicDay) {
            binding.epicDate.text = epicDay.date
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