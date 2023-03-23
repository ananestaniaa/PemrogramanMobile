package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

//Aktivitas ini memungkinkan pengguna melempar dadu dan melihat hasilnya di layar.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    //Lempar dadu dan perbarui layar dengan hasilnya.
    private fun rollDice() {
        //Buat objek Dadu baru dengan 6 sisi dan gulung
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Menemukan ImageView di tata letak
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_1)

        //Menentukan ID sumber daya dapat digambar mana yang akan digunakan berdasarkan lemparan dadu
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Memperbarui ImageView dengan ID sumber daya dapat digambar yang benar
        diceImage.setImageResource(drawableResource)

        //Memperbarui deskripsi konten
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}