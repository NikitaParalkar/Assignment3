package sheridan.paralkar.assignment3.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ca.tetervak.flowerdata.domain.Flower
import sheridan.paralkar.assignment3.R
import sheridan.paralkar.assignment3.databinding.FlowerListItemBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */

class FlowerListAdapter (): ListAdapter<Flower, FlowerListAdapter.ViewHolder>(FlowerDiffCallback()) {

    class ViewHolder private constructor(
        private val binding: FlowerListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(count: Int, flower: Flower) {
            binding.count.text = binding.root.context.getString(R.string.count, count)
            binding.flower = flower
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FlowerListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position + 1, getItem(position))
    }

    class FlowerDiffCallback : DiffUtil.ItemCallback<Flower>() {
        override fun areItemsTheSame(oldItem: Flower, newItem: Flower): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Flower, newItem: Flower): Boolean {
            return oldItem == newItem
        }
    }
}
