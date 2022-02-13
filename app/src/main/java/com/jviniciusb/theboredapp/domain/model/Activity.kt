package com.jviniciusb.theboredapp.domain.model

data class Activity(
    val activity: String,
    val type: String,
    val participants: Long,
    val price: Double,
    val link: String,
    val key: String,
    val accessibility: Double
)
