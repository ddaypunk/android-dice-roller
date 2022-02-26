package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This class allows the user to roll a die and view it's result on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    private fun rollDice() {
        // roll first die
        val dice = Die(6)
        val result = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

        diceImage.setImageResource(getDieResourceWith(result))
        diceImage.contentDescription = result.toString()

        // roll second die
        val dice2 = Die(6)
        val result2 = dice2.roll()

        val diceImage2: ImageView = findViewById(R.id.imageView2)

        diceImage2.setImageResource(getDieResourceWith(result2))
        diceImage2.contentDescription = result2.toString()
    }

    private fun getDieResourceWith(sides: Int): Int {
        return when (sides) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}

/**
 * A simple encapsulation of a die with a certain number of `sides`
 */
class Die(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}