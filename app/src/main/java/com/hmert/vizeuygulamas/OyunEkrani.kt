package com.hmert.vizeuygulamas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class OyunEkrani : AppCompatActivity() {
    var meyveler = listOf("elma", "muz", "kiraz", "portakal", "cilek", "armut", "ananas", "karpuz", "seftali", "avokado", "mandalina", "kavun", "kivi")
    var secilenKelime = ""
    var kelimeninKaristirilmisi = ""
    var skor = 0

    private lateinit var puanMetni: TextView
    private lateinit var karisikKelimeMetni: TextView
    private lateinit var tahminGirisi: EditText
    private lateinit var onayButonu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.oyun_ekrani)

        puanMetni = findViewById(R.id.scoreTextView)
        karisikKelimeMetni = findViewById(R.id.shuffledWordTextView)
        tahminGirisi = findViewById(R.id.guessInput)
        onayButonu = findViewById(R.id.submitGuessButton)

        kelimeKaristirici()

        onayButonu.setOnClickListener {
            val guess = tahminGirisi.text.toString().trim()
            if (guess.equals(secilenKelime, ignoreCase = true)) {
                skor += 10
                puanMetni.text = "Puan: $skor"
                Toast.makeText(this, "Doğru Tahmin! +10 puan", Toast.LENGTH_SHORT).show()
                kelimeKaristirici()
                tahminGirisi.text.clear()
            } else {
                Toast.makeText(this, "Yanlış tahmin! Tekrar deneyin.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun kelimeKaristirici() {
        secilenKelime = meyveler.random()
        kelimeninKaristirilmisi = secilenKelime.toCharArray().apply { shuffle() }.concatToString()
        karisikKelimeMetni.text = kelimeninKaristirilmisi
    }
}
