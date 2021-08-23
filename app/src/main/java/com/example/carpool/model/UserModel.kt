package com.example.carpool.model

import com.example.carpool.data.db.Reservation
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class UserModel(
    val id: Int = 0, // TODO After inserting static 5 users, convert the initializer to accept only DAO, bind variables from that DAO
    val email: String,
    val password: String,
    private val reservationListJson: String,
    val isAdmin: Boolean
) {
    val reservations: List<Reservation>

    init {
        val type = TypeToken.getParameterized(ArrayList::class.java, Reservation::class.java).type
        reservations = Gson().fromJson(reservationListJson, type)
    }
}
