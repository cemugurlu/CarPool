package com.example.carpool.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.carpool.R
import com.example.carpool.model.CarModel

class CarRecyclerAdapter(val context: Context, val cars: ArrayList<CarModel>, val beginIndex: Int): RecyclerView.Adapter<CarRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tv_car_model)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_car, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = cars.get(position + beginIndex)
        holder.textView.text = car.name
        holder.view.setOnClickListener {
            Toast.makeText(context, car.name, Toast.LENGTH_SHORT).show()
        }
    }


    override fun getItemCount(): Int {
        return cars.size - beginIndex
    }


}