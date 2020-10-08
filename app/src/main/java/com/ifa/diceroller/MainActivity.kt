package com.ifa.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * Activity ini merupakan activity yang memberikan user untuk dapat mengkocok dadu dan melihat
 * hasilnya di layar mereka
 */

class MainActivity : AppCompatActivity() {

    /**
     * Method ini dipanggil ketika activity dibuat
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buat variabel rollButton dan cari id button di layout nya
        val rollButton: Button = findViewById(R.id.button)

        // Buat variabel rollButton dapat di klik agar ketika di klik melakukan kocok dadu
        rollButton.setOnClickListener {
            // Jalankan fungsi kocok dadu atau rollDice
            rollDice()
        }
    }

    /**
     * Fungsi kocok dadu untuk mengkocok dadu dan tampilkan hasilnya ke layar
     */
    private fun rollDice() {
        // Membuat objek dadu dengan nama dice
        val dice = Dice()

        // Panggil fungsi kocok dadu pada objek dadu dan simpan nilai nya di diceRoll
        val diceRoll : Int = dice.roll()

        // Cari imageview di layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Sesuaikan hasil dadu dengan gambar
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update imageView dan Tampilkan hasil dadu sesuai gambar
        diceImage.setImageResource(drawableResource)

        // Update contentDescription
        diceImage.contentDescription = diceRoll.toString()

    }
}

/**
 * Kelas dadu dengan sebuah sisi angka
 */

class Dice(val numSides: Int = 6, val colorDice: String = "White") {

    /**
     * Fungsi untuk melakukan kocok dadu secara random dan kembalikan nilainya
     */

    fun roll(): Int {
        return (1..numSides).random()
    }

}