package com.hmert.vizeuygulamas

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AcilisEkrani : AppCompatActivity() {

    private lateinit var sayacMetni: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acilis_ekrani)

        sayacMetni = findViewById(R.id.sayacMetni)

        // Geri sayım eklemek için CountDownTimer kullanımı
        object : CountDownTimer(6000, 1000) { // 6 saniye, her 1 saniyede bir geri sayım
            override fun onTick(ms: Long) {
                val kalansn = ms / 1000
                sayacMetni.text = "$kalansn"
            }

            override fun onFinish() {
                // Sayaç tamamlandığında LoginActivity'ye geçiş
                val gecis = Intent(this@AcilisEkrani, GirisEkrani::class.java)
                startActivity(gecis)
                finish() // Splash ekranını kapat
            }
        }.start()
    }
}
