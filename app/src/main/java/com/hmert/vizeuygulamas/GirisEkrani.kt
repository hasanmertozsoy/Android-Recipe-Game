package com.hmert.vizeuygulamas

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class GirisEkrani : AppCompatActivity() {

    private lateinit var kayitTut: SharedPreferences
    private lateinit var kullaniciAdi: EditText
    private lateinit var sifre: EditText
    private lateinit var kontrol: CheckBox
    private lateinit var girisYap: Button
    // private lateinit şu anlama gelir: Bu değişkenler daha sonra atanacaktır.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.giris_ekrani)

        kullaniciAdi = findViewById(R.id.kullaniciAdi)
        sifre = findViewById(R.id.sifre)
        kontrol = findViewById(R.id.kontrol)
        girisYap = findViewById(R.id.girisYap)
        // Layout'daki bileşenleri tanımlama
        // SharedPreferences setup
        kayitTut = getSharedPreferences("girisBilgileri", MODE_PRIVATE)

        // Load saved credentials if "Bilgilerimi Hatırla" is checked
        loadSavedCredentials()

        girisYap.setOnClickListener {
            val username = kullaniciAdi.text.toString()
            val password = sifre.text.toString()

            if (username == "hasanmert" && password == "123") {
                if (kontrol.isChecked) {
                    saveCredentials(username, password)
                } else {
                    clearSavedCredentials()
                }
                Toast.makeText(this, "Giriş başarılı!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Kullanıcı adı veya şifre hatalı!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // SharedPreferences'ten bilgileri geri dönüşte silme onRestart ile
    override fun onRestart() {
        super.onRestart()
        setContentView(R.layout.giris_ekrani)
        // kullaniciAdi ve sifre'nin içeriğini temizle
        kullaniciAdi = findViewById(R.id.kullaniciAdi)
        sifre = findViewById(R.id.sifre)
        kontrol = findViewById(R.id.kontrol)
        girisYap = findViewById(R.id.girisYap)
        // Layout'daki bileşenleri tanımlama
        // SharedPreferences setup
        kayitTut = getSharedPreferences("girisBilgileri", MODE_PRIVATE)
        girisYap.setOnClickListener {
            val username = kullaniciAdi.text.toString()
            val password = sifre.text.toString()

            if (username == "hasanmert" && password == "123") {
                if (kontrol.isChecked) {
                    saveCredentials(username, password)
                } else {
                    clearSavedCredentials()
                }
                Toast.makeText(this, "Giriş başarılı!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Kullanıcı adı veya şifre hatalı!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadSavedCredentials() {
        val kayitliKullaniciAdi = kayitTut.getString("username", null)
        val kayitliSifre = kayitTut.getString("password", null)

        kullaniciAdi.setText(kayitliKullaniciAdi)
        sifre.setText(kayitliSifre)
        kontrol.isChecked = true

    }
    // SharedPreferences'e bilgileri kaydetme
    private fun saveCredentials(username: String, password: String) {
        val editor = kayitTut.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.putBoolean("rememberMe", true)
        editor.apply()
    }
    // SharedPreferences'ten bilgileri silme
    private fun clearSavedCredentials() {
        val editor = kayitTut.edit()
        editor.clear()
        editor.apply()
    }
}
