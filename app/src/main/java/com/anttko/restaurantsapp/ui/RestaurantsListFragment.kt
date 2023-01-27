package com.anttko.restaurantsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.anttko.restaurantsapp.R
import com.anttko.restaurantsapp.databinding.FragmentRestaurantsListBinding


class RestaurantsListFragment : Fragment() {
    private val viewModel: RestaurantsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRestaurantsListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = RestaurantsAdapter(RestaurantsListener { item ->
            viewModel.onRestaurantClicked(item)
            findNavController().navigate(R.id.action_restaurantsListFragment_to_restaurantFragment)
        })
        return binding.root

    }
}