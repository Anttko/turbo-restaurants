package com.anttko.restaurantsapp

import android.widget.ImageView

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anttko.restaurantsapp.data.Item
import com.anttko.restaurantsapp.data.Restaurants
import com.anttko.restaurantsapp.data.Venue
import com.anttko.restaurantsapp.ui.RestaurantsAdapter

import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Item>?) {
    val adapter = recyclerView.adapter as RestaurantsAdapter
    adapter.submitList(data)
}

@BindingAdapter("image")
fun bindImage(imgView: ImageView, image: String) {
    val transformation = MultiTransformation(CenterCrop(), RoundedCorners(10))
    Glide.with(imgView)
        .load(image)
        .transform(transformation)
        .into(imgView)
}

/**
 *
 * @BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: Restaurants?) {
val adapter = recyclerView.adapter as RestaurantsAdapter
adapter.submitList(data)
}

@BindingAdapter("image")
fun bindImage(imgView: ImageView, image: String) {
Glide.with(imgView)
.load(image)
.circleCrop()
.into(imgView)
}

 *
 *
 *
 *
 *
 */
