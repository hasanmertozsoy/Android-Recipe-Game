package com.hmert.vizeuygulamas

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class YemekDetaylari : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.yemek_detaylari)

        val yemekAdi = intent.getStringExtra("yemekAdi") ?: "Bilinmiyor"
        val malzemeler = intent.getStringExtra("malzemeler") ?: "Malzeme bilgisi yok"
        val tarif = intent.getStringExtra("tarif") ?: "Tarif bilgisi yok"

        val yemekAdiBolumu = findViewById<TextView>(R.id.yemekAdiTextView)
        val malzemelerBolumu = findViewById<TextView>(R.id.malzemelerTextView)
        val tarifBolumu = findViewById<TextView>(R.id.tarifTextView)

        yemekAdiBolumu.text = yemekAdi
        malzemelerBolumu.text = malzemeler
        tarifBolumu.text = tarif
    }
}
