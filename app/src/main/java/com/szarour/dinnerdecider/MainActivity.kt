package com.szarour.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    val foodList = arrayListOf(
        "Chinese",
        "Mexican",
        "Burger",
        "Pizza",
        "Pasta",
        "Fish & Chips",
        "Salad",
        "Vegan Burger",
        "Kebab"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideBtn.setOnClickListener {
            if (foodList.isNotEmpty()) {
                var random = Random().nextInt(foodList.size)
                val currentIndex = foodList.indexOf(selectedFoodTxt.text)
                while (random == currentIndex) {
                    random = Random().nextInt(foodList.size)
                }
                selectedFoodTxt.text = foodList[random]
            }
        }

        addFoodBtn.setOnClickListener {
            val txt = addFoodTxt.text.toString()
            if (txt.isNotEmpty()) {
                foodList.add(txt)
                addFoodTxt.text.clear()
                selectedFoodTxt.text = txt
            } else println("Empty text to add")

        }

        removeBtn.setOnClickListener {
            val txt = selectedFoodTxt.text.toString()
            foodList.remove(txt)
            if (foodList.isNotEmpty()) {
                val random = Random().nextInt(foodList.size)
                selectedFoodTxt.text = foodList[random]
            } else selectedFoodTxt.text = "vide"
        }
    }
}
