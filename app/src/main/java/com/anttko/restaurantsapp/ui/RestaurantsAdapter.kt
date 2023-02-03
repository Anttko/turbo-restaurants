package com.anttko.restaurantsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anttko.restaurantsapp.data.Item
import com.anttko.restaurantsapp.databinding.ListViewItemBinding
class RestaurantsAdapter(private val clickListener: RestaurantsListener) :
    ListAdapter<Item, RestaurantsAdapter.RestaurantsViewHolder>(DiffCallback) {

    class RestaurantsViewHolder(
        private var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: RestaurantsListener, items: Item) {
            binding.items = items
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.title == newItem.title && oldItem.venue == newItem.venue
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  RestaurantsViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val restaurants = getItem(position)
        holder.bind(clickListener, restaurants)
    }
}
class RestaurantsListener(val clickListener: (items: Item) -> Unit) {
    fun onClick(items: Item) = clickListener(items)

}
