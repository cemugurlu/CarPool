package com.example.carpool.ui.rent

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.carpool.R
import com.example.carpool.databinding.FragmentRentBinding
import com.example.carpool.model.CarModel
import java.util.*

class RentFragment : Fragment(R.layout.fragment_rent), RentInterface {

    private lateinit var binding: FragmentRentBinding
    private lateinit var viewModel: RentViewModel
    val myCalendar = Calendar.getInstance()
    private val year = myCalendar.get(Calendar.YEAR)
    private val month = myCalendar.get(Calendar.MONTH)
    private val day = myCalendar.get(Calendar.DAY_OF_MONTH)

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(
            this,
            RentViewModelFactory(this)
        ).get(RentViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rent, container, false)
        binding.myViewModel = viewModel

        val cars = ArrayList<CarModel>()
        cars.add(CarModel(name = "test", index = 0))
        cars.add(CarModel(name = "test1", index = 1))
        cars.add(CarModel(name = "test2", index = 2))
        cars.add(CarModel(name = "test3", index = 3))
        cars.add(CarModel(name = "test4", index = 4))
        cars.add(CarModel(name = "test5", index = 5))
        cars.add(CarModel(name = "test6", index = 6))
        cars.add(CarModel(name = "test7", index = 7))
        cars.add(CarModel(name = "test8", index = 8))
        cars.add(CarModel(name = "test9", index = 9))
        cars.add(CarModel(name = "test10", index = 10))

        /*cars.removeIf {
            it.index > 4
        }*/

        context?.let { // unwrap the context
            binding.rvCarList.adapter = CarRecyclerAdapter(it, cars = cars, beginIndex = 0)

        }

        /*viewModel.buttonGetDateText.observe(viewLifecycleOwner) { newValue ->
            Log.d("asd", newValue)
        }*/


        return binding.root

    }

    private fun createDatePicker(
        context: Context,
        listener: DatePickerDialog.OnDateSetListener
    ): DatePickerDialog {
        return DatePickerDialog(context, listener, year, month, day)
    }

    override fun openGetDatePickerDialog() {
        context?.let {
            createDatePicker(context = it) { view, year, monthOfYear, dayOfMonth ->
                val monthOfYear = monthOfYear + 1
                binding.buttonGetDate.text = " $dayOfMonth $monthOfYear $year"
            }
        }?.show()

    }

    override fun openReturnDatePickerDialog() {
        context?.let {
            createDatePicker(context = it) { view, year, monthOfYear, dayOfMonth ->
                val monthOfYear = monthOfYear + 1
                binding.buttonReturnDate.text = " $dayOfMonth $monthOfYear $year"
            }
        }?.show()

    }


}






