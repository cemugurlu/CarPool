package com.example.carpool.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.carpool.R

class MainFragment : Fragment(R.layout.fragment_main) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)


        // access to buttonView
        val buttonMain = view.findViewById<Button>(R.id.button_main)
        buttonMain.setOnClickListener {

        }
        return view

    }
}