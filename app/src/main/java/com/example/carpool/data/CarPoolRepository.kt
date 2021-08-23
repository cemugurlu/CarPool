package com.example.carpool.data

import androidx.lifecycle.LiveData
import com.example.carpool.data.db.Car
import com.example.carpool.data.db.CarPoolDao
import com.example.carpool.data.db.CarPoolDatabase
import com.example.carpool.model.UserEntity
import com.example.carpool.model.UserModel
import com.google.gson.Gson

class CarPoolRepository() {

    lateinit var dao: CarPoolDao
    var loginDatabase: CarPoolDatabase? = null
    var readAllData: LiveData<UserModel>? = null

    companion object {
        @Volatile
        private var INSTANCE: CarPoolRepository? = null


        fun getInstance(dao: CarPoolDao): CarPoolRepository {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = CarPoolRepository()
                }
                INSTANCE!!.dao = dao
            }
            return INSTANCE!!
        }
    }

    suspend fun insertUser(user: UserModel) {
        dao.insertUser(
            UserEntity(
                email = user.email, password = user.password,
                reservations = Gson().toJson(user.reservations),
                isAdmin = user.isAdmin
            )
        )
    }

    suspend fun insertCar(car: Car) {
        dao.insertCar(car)
    }

    suspend fun updateUser(userEntity: UserEntity) {
        dao.updateUser(userEntity)
    }

    suspend fun updateCar(car: Car) {
        dao.updateCar(car)
    }

    suspend fun deleteUser(user: UserModel) {
        dao.deleteUser(
            UserEntity(
                email = user.email, password = user.password,
                reservations = Gson().toJson(user.reservations),
                isAdmin = user.isAdmin
            )
        )
    }

    suspend fun deleteCar(car: Car) {
        dao.deleteCar(car)
    }

    suspend fun deleteAllUsers() {
        dao.deleteAllUsers()
    }

    suspend fun deleteAllCars() {
        dao.deleteAllUsers()
    }

    fun getAllUsers(): List<UserModel> {
        var users = ArrayList<UserModel>()
        for (user in dao.getAllUsers()) {
            // TODO will be dao, will be changed after importing static users // users.add(UserModel(dao))
        }
        return users
    }

    fun getAllCars(): LiveData<List<Car>> {
        return dao.getAllCars()
    }



    //fun bookCar()

}