package com.example.carpool.db

class CarPoolRepository(private var dao: CarPoolDao) {

    val users = dao.getAllUsers()
    val cars = dao.getAllCars()

    suspend fun insertUser(user: User){
        dao.insertUser(user)
    }

    suspend fun insertCar(car: Car) {
        dao.insertCar(car)
    }

    suspend fun updateUser(user: User) {
        dao.updateUser(user)
    }

    suspend fun updateCar(car: Car) {
        dao.insertCar(car)
    }

    suspend fun deleteUser(user: User){
        dao.deleteUser(user)
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

}