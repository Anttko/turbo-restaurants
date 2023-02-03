package com.anttko.restaurantsapp.ui
import android.app.Application
import androidx.lifecycle.*
import com.anttko.restaurantsapp.data.Item
import com.anttko.restaurantsapp.network.RestaurantsApi
import com.birjuvachhani.locus.Locus
import kotlinx.coroutines.launch
class RestaurantsViewModel(application: Application) : AndroidViewModel(application) {
    private val _venues = MutableLiveData<List<Item>?>()
    val venues: LiveData<List<Item>?> = _venues
    private val _venue = MutableLiveData<Item>()
    val venue: LiveData<Item> = _venue
    init {
        getCoordinates()
    }
    private fun getCoordinates() {
        viewModelScope.launch {
            Locus.getCurrentLocation(getApplication()) { result ->
                result.location?.let {
                    println("coords: " + it.latitude + it.longitude)
                    getRestaurants(it.latitude, it.longitude)
                }
                result.error?.let { /* Received error! */ }
            }
        }
    }
    private fun getRestaurants(latitude: Double, longitude:Double) {
        viewModelScope.launch {
            try {
                val response = RestaurantsApi.retrofitService.getRestaurants(latitude, longitude)
                val venues = response.sections?.get(1)?.items?.take(15)?.map { it }
                _venues.value = venues
            } catch (e: Exception) {
                println("ERROR IN RESTAURANTS $e")
                _venues.value = emptyList()
            }
        }
    }
    fun onRestaurantClicked(venue: Item) {
        _venue.value = venue
        venue.favorite = venue.favorite == false
    }
}
