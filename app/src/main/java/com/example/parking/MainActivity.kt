package com.example.parking

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.parking.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var parking1: Parking
    private lateinit var parking2: Parking
    private lateinit var parking3: Parking
    private var current: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        parking1 = Parking(" ", " ", " ", " ", false, 1)
        parking2 = Parking(" ", " ", " ", " ", false, 2)
        parking3 = Parking(" ", " ", " ", " ", false, 3)
        binding.apply {
            slot1Button.setOnClickListener{
                current = 1
                showInfo(it, 1)
            }
            slot2Button.setOnClickListener{
                current = 2
                showInfo(it, 2)
            }
            slot3Button.setOnClickListener {
                current = 3
                showInfo(it, 3)
            }

            update_button.setOnClickListener{
                if (current == 1){
                    parking1.status = true
                }else if (current == 2){
                    parking2.status = true
                }else if (current == 3){
                    parking3.status = true
                }else{
                    println("Error int = 0")
                }
                showInfo(it, current)
            }
            delete_button.setOnClickListener{
                if (current == 1){
                    parking1.status = false
                }else if (current == 2){
                    parking2.status = false
                }else if (current == 3){
                    parking3.status = false
                }else{
                    println("Error int = 0")
                }
                showInfo(it, current)
            }

        }
        binding.parking = parking1
        binding.parking = parking2
        binding.parking = parking3

    }

    private fun showInfo(view: View, i: Int) {
        binding.apply {
            if (parking1.status.equals(true) && i == 1) {
                println(current)
                parking1.name = nameEditText.text.toString()
                parking1.licensePlate = licensePlateEditText.text.toString()
                parking1.carBrand = carBrandEditText.text.toString()
                parking1.telNumber = telNumberEditText.text.toString()
            }else if (parking1.status == false && i == 1){
            parking1.name = " "
            parking1.licensePlate = " "
            parking1.carBrand = " "
            parking1.telNumber = " "
            }

            if (parking2.status == true && i == 2){
                println(current)
                parking2.name = nameEditText.text.toString()
                parking2.licensePlate = licensePlateEditText.text.toString()
                parking2.carBrand = carBrandEditText.text.toString()
                parking2.telNumber = telNumberEditText.text.toString()

            }else if (parking2.status == false && i == 2){
                parking2.name = " "
                parking2.licensePlate = " "
                parking2.carBrand = " "
                parking2.telNumber = " "
            }

            if (parking3.status == true && i == 3){
                println(current)
                parking3.name = nameEditText.text.toString()
                parking3.licensePlate = licensePlateEditText.text.toString()
                parking3.carBrand = carBrandEditText.text.toString()
                parking3.telNumber = telNumberEditText.text.toString()
            }else if (parking3.status == false && i == 3){
                parking3.name = " "
                parking3.licensePlate = " "
                parking3.carBrand = " "
                parking3.telNumber = " "
            }

            invalidateAll()
            nameEditText.clearFocus()
        }
        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
