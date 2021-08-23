package com.example.carpool.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data_table")
data class UserEntity(
//TODO: add variables (password)

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val id: Int = 0,

    @ColumnInfo(name = "user_email")
    val email: String,

    //Not the best practice ://
    @ColumnInfo(name = "password")
    val password: String,

    @ColumnInfo(name = "reservations")
    val reservations: String,

    @ColumnInfo(name = "is_admin")
    val isAdmin: Boolean

    //TODO: how to store  admin  on database with best practice. google it

)