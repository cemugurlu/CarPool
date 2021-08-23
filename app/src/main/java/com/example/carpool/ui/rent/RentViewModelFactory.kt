package com.example.carpool.ui.rent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RentViewModelFactory(val rentInterface: RentInterface): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RentViewModel::class.java)){
            return RentViewModel(rentInterface = rentInterface) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }

}