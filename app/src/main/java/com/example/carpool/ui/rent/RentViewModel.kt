package com.example.carpool.ui.rent

import androidx.lifecycle.ViewModel

class RentViewModel(val rentInterface: RentInterface): ViewModel() {

    fun onButtonGetDateClick() {
        rentInterface.openGetDatePickerDialog()
    }

    fun onButtonReturnDateClick() {
        rentInterface.openReturnDatePickerDialog()
    }
}