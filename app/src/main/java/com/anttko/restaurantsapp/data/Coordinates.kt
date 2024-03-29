package com.anttko.restaurantsapp.data

data class Coordinates (
    val latitude: Double,
    val longitude: Double
)

val exampledata: List<Coordinates> = listOf(
    Coordinates(60.170187, 24.930599),
    Coordinates(60.169418, 24.931618),
    Coordinates(60.169818, 24.932906),
    Coordinates(60.170005, 24.935105),
    Coordinates(60.169108, 24.936210),
    Coordinates(60.168355, 24.934869),
    Coordinates(60.167560, 24.932562),
    Coordinates(60.168254, 24.931532),
    Coordinates(60.169012, 24.930341),
    Coordinates(60.170085, 24.929569),
)
var example: Coordinates =  exampledata.random()
