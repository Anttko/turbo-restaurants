package com.anttko.restaurantsapp.network

import com.anttko.restaurantsapp.data.Restaurants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://restaurant-api.wolt.com/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RestaurantsApiService {
    @GET("v1/pages/restaurants")
    suspend fun getRestaurants(
        @Query("lat") lat: Double?,
        @Query("lon") lon: Double?
    ): Restaurants
}

object RestaurantsApi {
    val retrofitService: RestaurantsApiService by lazy {
        retrofit.create(RestaurantsApiService::class.java)
    }
}

