package com.example.carpool.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carpool.data.CarPoolRepository
import com.example.carpool.data.db.Car
import com.example.carpool.data.db.CarPoolDatabase
import com.example.carpool.data.db.Reservation
import com.example.carpool.model.UserEntity
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginInterface: LoginInterface,
    application: Application

) : AndroidViewModel(application) {
    val repository: CarPoolRepository
        get() = CarPoolRepository.getInstance(
            CarPoolDatabase.getInstance(getApplication()).carPoolDao()
        )
    val email = MutableLiveData("")
    val password = MutableLiveData("")


    fun onClickButtonMain() {
        viewModelScope.launch(Dispatchers.IO) {
            // repository.insertUser(User(123,"asdasdasd","asdasdasd"))
            //Log.d("TAGG", repository.getAllUsers().get(0).name)
            val array = Gson().toJson(ArrayList<Reservation>())


/*


            repository.insertUser(
                UserModel(
                    email = "cem@token",
                    password = "123",
                    reservationListJson = array,
                    isAdmin = false
                )
            )
            Log.d("TAGG", repository.getAllUsers().get(0).reservations.toString())


*/


        }

        loginInterface.onNavigateToMainFragment()


        /*if (email.value.equals("cem") && password.value.equals("1234")) {
            loginInterface.onNavigateToMainFragment()
        }*/

    }


    fun updateUser(userEntity: UserEntity) = viewModelScope.launch {
        repository.updateUser(userEntity)
    }

    fun insertCar(car: Car) = viewModelScope.launch {
        repository.insertCar(car)
    }

    fun deleteCar(car: Car) = viewModelScope.launch {
        repository.deleteCar(car)
    }

    fun updateCar(car: Car) = viewModelScope.launch {
        repository.updateCar(car)
    }

    fun deleteAllUsers() = viewModelScope.launch {
        repository.deleteAllUsers()
    }

    fun deleteAllCars() = viewModelScope.launch {
        repository.deleteAllCars()

    }


}


