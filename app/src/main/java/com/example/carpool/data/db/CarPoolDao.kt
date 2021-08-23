package com.example.carpool.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.carpool.model.UserEntity
import com.example.carpool.model.UserModel

@Dao
interface CarPoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCar(car: Car)

    @Update
    suspend fun updateUser(userEntity: UserEntity)

    @Update
    suspend fun updateCar(car: Car)

    @Delete
    suspend fun deleteUser(userEntity: UserEntity)

    @Delete
    suspend fun deleteCar(car: Car)


    @Query("DELETE FROM user_data_table ")
    suspend fun deleteAllUsers()

    @Query("DELETE FROM car_data_table ")
    suspend fun deleteAllCars()

    @Query("SELECT * FROM user_data_table")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM car_data_table")
    fun getAllCars(): LiveData<List<Car>>
     

    @Query("SELECT * FROM user_data_table WHERE user_email LIKE :email AND password LIKE :password")
    fun readAllData(email: String, password: String): LiveData<UserModel>

}