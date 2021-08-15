package com.example.carpool.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CarPoolDao {
    @Insert
    suspend fun insertUser(user: User)

    @Insert
    suspend fun insertCar(car: Car)

    @Update
    suspend fun updateUser(user: User)

    @Update fun updateCar(car: Car)

    @Delete
    suspend fun deleteUser(user: User)

    @Delete
    suspend fun deleteCar(car: Car)


    @Query("DELETE FROM user_data_table ")
    suspend fun deleteAllUsers()

    @Query("DELETE FROM car_data_table ")
    suspend fun deleteAllCars()

    @Query("SELECT * FROM user_data_table")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM car_data_table")
    fun getAllCars(): LiveData<List<Car>>

}