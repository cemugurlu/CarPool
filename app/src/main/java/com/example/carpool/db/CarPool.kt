package com.example.carpool.db

import android.net.wifi.WifiManager
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data_table")
data class User(
//TODO: eklenecek şeyler olacak (password)

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "user_id")
    val id: Int,

    @ColumnInfo(name = "user_name")
    val name:String,

    @ColumnInfo(name= "user_isAdmin")
    val isAdmin: Boolean


)

@Entity(tableName = "car_data_table")
data class Car(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "car_id")
    val id: Int,

    @ColumnInfo(name = "car_model")
    val carModel: String,

    @ColumnInfo(name = "time_of_reservation")
    val timeOfReservation: String
)

