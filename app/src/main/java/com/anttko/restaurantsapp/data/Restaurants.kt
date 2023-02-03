package com.anttko.restaurantsapp.data

import com.google.gson.annotations.SerializedName
data class Restaurants(
    val created: Created? = null,
    val expires_in_seconds: Int? = null,
    val filtering: Filtering? = null,
    val name: String? = null,
    val page_title: String? = null,
    val sections: List<Section>? = null,
    val show_large_title: Boolean? = null,
    val show_map: Boolean? = null,
    val sorting: SortingX? = null,
    val track_id: String? = null
)

data class Created(
    @SerializedName("\$date") var date: Int? = null
)

data class Filtering(
    val filters: List<Filter>? = null
)

data class Section(
    val items: List<Item>? = null,
    val link: LinkX? = null,
    val name: String? = null,
    val template: String? = null,
    val title: String? = null
)

data class SortingX(
    val sortables: List<SortableX>? = null
)

data class Filter(
    val id: String? = null,
    val name: String? = null,
    val type: String? = null,
    val values: List<Value>? = null
)

data class Value(
    val id: String? = null,
    val name: String? = null
)

data class Item(
    var favorite: Boolean? = false,
    val description: String? = null,
    val filtering: FilteringX? = null,
    val image: Image? = null,
    val link: Link? = null,
    val overlay: String? = null,
    val quantity: Int? = null,
    val quantity_str: String? = null,
    val sorting: Sorting? = null,
    val template: String? = null,
    val title: String? = null,
    val track_id: String? = null,
    val venue: Venue? = null
)

data class LinkX(
    val target: String? = null,
    val target_sort: String? = null,
    val target_title: String? = null,
    val title: String? = null,
    val type: String? = null
)

data class FilteringX(
    val filters: List<FilterX>? = null
)

data class Image(
    val blurhash: String? = null,
    val url: String? = null
)

data class Link(
    val target: String? = null,
    val target_sort: String? = null,
    val target_title: String? = null,
    val title: String? = null,
    val type: String? = null,
    val venue_mainimage_blurhash: String? = null
)

data class Sorting(
    val sortables: List<Sortable>? = null
)

data class Venue(
    val address: String? = null,
    val badges: List<Badge>? = null,
    val categories: List<Any>? = null,
    val city: String? = null,
    val country: String? = null,
    val currency: String? = null,
    val delivers: Boolean? = null,
    val delivery_price: String? = null,
    val delivery_price_highlight: Boolean? = null,
    val delivery_price_int: Int? = null,
    val estimate: Int? = null,
    val estimate_range: String? = null,
    val franchise: String? = null,
    val id: String? = null,
    val location: List<Double>? = null,
    val name: String? = null,
    val online: Boolean? = null,
    val price_range: Int? = null,
    val product_line: String? = null,
    val promotions: List<Any>? = null,
    val rating: Rating? = null,
    val short_description: String? = null,
    val show_wolt_plus: Boolean? = null,
    val slug: String? = null,
    val tags: List<String>? = null
)

data class FilterX(
    val id: String? = null,
    val values: List<String>? = null
)

data class Sortable(
    val id: String? = null,
    val value: Int? = null
)

data class Badge(
    val text: String? = null,
    val variant: String? = null
)

data class Rating(
    val rating: Int? = null,
    val score: Double? = null
)

data class SortableX(
    val id: String? = null,
    val name: String? = null,
    val type: String? = null
)