package com.example.carpool.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "car_data_table")
data class Car(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "car_id")
    val id: Int,

    @ColumnInfo(name = "car_model")
    val carModel: String,

    @ColumnInfo(name = "time_of_reservation")
    val timesOfReservation: String
    //TODO: time: Long, or DateTime Object google it
    //TODO: One-to-many car will be implemented

)

@Entity(tableName = "reservation_data_table")
data class Reservation(
    //TODO revise
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "reservation_id")
    val id: Int,

    @ColumnInfo(name = "reservation_user_id")
    val reservationUserID: Int,

    @ColumnInfo(name = "start_date")
    val startDate: Int,

    @ColumnInfo(name = "end_date")
    val endDate: Int,

    @ColumnInfo(name = "car_id")
    val carId: Int
)

