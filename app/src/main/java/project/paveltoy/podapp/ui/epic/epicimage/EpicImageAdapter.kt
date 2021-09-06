package project.paveltoy.podapp.ui.epic.epicimage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import project.paveltoy.podapp.databinding.ItemEpicImageBinding

class EpicImageAdapter : RecyclerView.Adapter<EpicImageAdapter.EpicImageViewHolder>() {
    var imageData: List<String> = listOf()

    class EpicImageViewHolder(private val binding: ItemEpicImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(imgAddress: String) {
                Picasso.get().load(imgAddress).into(binding.epicImageView)
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpicImageViewHolder {
        val binding =
            ItemEpicImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpicImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpicImageViewHolder, position: Int) {
        holder.bind(imageData[position])
    }

    override fun getItemCount(): Int = imageData.size
}