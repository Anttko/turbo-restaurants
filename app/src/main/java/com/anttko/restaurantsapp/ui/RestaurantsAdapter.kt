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
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: RestaurantsListener, venues: Item) {
            binding.venues = venues
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem && oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RestaurantsViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val restaurants = getItem(position)
        holder.bind(clickListener, restaurants)
    }
}

class RestaurantsListener(val clickListener: (venues: Item) -> Unit) {
    fun onClick(venues: Item) = clickListener(venues)
}

/*
* class RestaurantsAdapter(private val clickListener: RestaurantsListener) :
    ListAdapter<Restaurants, RestaurantsAdapter.RestaurantsViewHolder>(DiffCallback) {

    class RestaurantsViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: RestaurantsListener, restaurants: Restaurants) {
            binding.restaurant = restaurants
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<Restaurants>() {
        override fun areItemsTheSame(oldItem: Restaurants, newItem: Restaurants): Boolean {
            return oldItem.created == newItem.created
        }

        override fun areContentsTheSame(oldItem: Restaurants, newItem: Restaurants): Boolean {
            return oldItem.sections == newItem.sections && oldItem.sections[0].link.title == newItem.sections[0].link.title
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RestaurantsViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }
    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val restaurants = getItem(position)
        holder.bind(clickListener, restaurants)
    }
}
class RestaurantsListener(val clickListener: (restaurants: Restaurants) -> Unit) {
    fun onClick(restaurants: Restaurants) = clickListener(restaurants)
}
*
*
*
*
* */