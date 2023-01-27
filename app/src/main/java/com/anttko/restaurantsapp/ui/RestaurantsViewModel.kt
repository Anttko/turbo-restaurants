package com.anttko.restaurantsapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anttko.restaurantsapp.data.Item
import com.anttko.restaurantsapp.data.Restaurants
import com.anttko.restaurantsapp.data.Venue
import com.anttko.restaurantsapp.network.RestaurantsApi
import kotlinx.coroutines.launch


class RestaurantsViewModel() : ViewModel() {
/*
    private val _restaurants = MutableLiveData<Restaurants>()
    val restaurants: LiveData<Restaurants> = _restaurants
    private val _restaurant = MutableLiveData<Restaurants>()
    val restaurant: LiveData<Restaurants> = _restaurant
    */

    private val _venues = MutableLiveData<List<Item>?>()
    val venues: LiveData<List<Item>?> = _venues

    private val _venue = MutableLiveData<Item>()
    val venue: LiveData<Item> = _venue

    init {
        getRestaurants()
    }

    private fun getRestaurants() {
        viewModelScope.launch {
            try {
                var lat = 60.170187
                var lon = 24.930599
                val response = RestaurantsApi.retrofitService.getRestaurants(lat, lon)
                val venues = response.sections?.get(1)?.items?.map { it }
                _venues.value = venues
            } catch (e: Exception) {
                println("ERROR IN RESTAURANTS $e")
                _venues.value = emptyList()
            }
        }
    }

    fun onRestaurantClicked(venue: Item) {
        _venue.value = venue
    }
}