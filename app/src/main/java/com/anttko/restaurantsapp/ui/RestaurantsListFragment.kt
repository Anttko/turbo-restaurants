package com.anttko.restaurantsapp.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.anttko.restaurantsapp.R
import com.anttko.restaurantsapp.data.Item
import com.anttko.restaurantsapp.databinding.FragmentRestaurantsListBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class RestaurantsListFragment : Fragment() {

    val viewModel: RestaurantsViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRestaurantsListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = RestaurantsAdapter(RestaurantsListener { item ->
            viewModel.onRestaurantClicked(item)
            binding.recyclerView.adapter?.notifyDataSetChanged()
        })
        return binding.root
    }
    }
