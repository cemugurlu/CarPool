package com.example.carpool.model

import java.util.*

data class CarModel(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val index: Int

)

