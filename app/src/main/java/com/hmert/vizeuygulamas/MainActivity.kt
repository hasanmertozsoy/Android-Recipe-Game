package com.hmert.vizeuygulamas

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val yemekListesi = mutableListOf(
        "Nohutlu Bamya Yemeği",
        "Adıyaman Usulü Etsiz Çiğ Köfte",
        "Adıyaman Kömbe"
    )

    private val yemekDetaylari = mutableMapOf(
        "Nohutlu Bamya Yemeği" to Pair(
            "Kullanılacak Malzemeler: 1 kilo bamya, 300 gram yağsız dana kuşbaşı, 2 su bardağı haşlanmış nohut, 1 orta boy kuru soğan, 2 orta boy domates, 1 yemek kaşığı domates-biber salçası karışımı, yarım çay bardağı zeytinyağı, yarım limon suyu, tuz, pulbiber, karabiber.",
            "Tarif: Eti yıkayıp süzdürerek pişirme tenceresine alıp kısık ateşte kendi suyunu salıp çekene kadar pişiriyoruz.\n" +
                    "Yemeklik doğranmış soğan ve yağı ilave edip kavuruyoruz.\n" +
                    "Salça ve rondodan geçirdiğimiz domatesleri ekleyip birkaç dakika kavuruyoruz.\n" +
                    "Haşlanmış nohut ve 3 su bardağı sıcak su ilave edip 5 dakika pişiriyoruz.\n" +
                    "Önceden ayıklayıp yıkayarak iyice süzdürdüğümüz bamyayı ekliyoruz.\n" +
                    "10 dakika orta dereceli ateşte pişmeye bırakıp bamyalar hafif yumuşayınca limon suyu ilave ediyoruz.\n" +
                    "2 su bardağı sıcak su ve baharatları ekleyip bamyalar pişene kadar kaynatıyoruz.\n" +
                    "Pişen yemeğimizi dinlendikten sonra servise hazır."
        ),
        "Adıyaman Usulü Etsiz Çiğ Köfte" to Pair(
            "Kullanılacak Malzemeler: Yarım kilo çiğ köftelik esmer bulgur, 2 adet büyük kuru soğan, 1 büyük baş sarımsak, Dolu bir yemek kaşığı domates salçası, 1 kase isot, 1 yemek kaşığı yedi türlü baharat, Maydanoz, 4 yemek kaşığı zeytin yağı",
            "Tarif: Bulguru yoğurma kabına koyuyoruz, üzerine ince doğradığımız soğanı, ezdiğimiz sarımsağı, salçasını bir miktar su ile ıslatılmış isotunu, yedi türlü baharatını, ve yarım kesilmiş limonu katıp yoğurmaya başlıyoruz.\n" +
                    "Yanımıza su alıyoruz ara ara elimizle su atarak yoğuruyoruz ta ki bulgur hafif yumuşayana kadar son olarak da zeytin yağı ile maydanozunu katıp on dakika daha yoğuruyoruz.\n" +
                    "Tüm bayanlarımızın yoğurabileceği bir çiğ köfte, devamlı kendim yoğururum kolay ve zevkli lavaş ve marul ve nar ekşisiyle çok iyi gidiyor, not, yoğururken attığımız limonun suyu bitince kabuğunu atıyoruz, afiyet olsun."
        ),
        "Adıyaman Kömbe" to Pair(
            "Kullanılacak Malzemeler: Hamuru için : 1 paket yaş maya, 1 çay bardağı sıcak su, 1 çay bardağı ılık süt, 1 buçuk kahve kaşığı tuz, 1 kg un. İç harcı: 400 gram kıyma, 3 adet soğan orta boy, 1 kaşık domates salçası, 1 kaşık biber salçası, Tuz, Karabiber, Yarım çay bardağı su, İsteğe göre maydanoz. Üzeri için: 2 yumurta, Susam.",
            "Tarif: Önce hamuru hazırlıyoruz. Bir derin kaba maya, şu, süt, tuz ekliyoruz mayayı içinde eritiyoruz.\n" +
                    "Sonra unu ilave edip yoğuruyoruz.\nYoğurma aşamasında sıcak şu ekleyerek sürekli yoğuruyoruz, kulak memesi kıvamına gelene kadar.\n" +
                    "Hamurun üzerini kapatıp mayalanmasını bekliyoruz.\n" +
                    "Bu esnada. Bir derin tava veya tencerede kıymayı koyup biraz su ( su yerine biraz sıvı yağ da katabiliriz) ile kavurmaya başlıyoruz.\n" +
                    "3 adet soğanı küçük küçük doğrayıp ekliyoruz.\n" +
                    "Soğanlar içinde biraz eriyene kadar kavuruyoruz. Biber ve domates salçasını ekliyoruz. Tuz ve karabiberi ilave ediyoruz.\n" +
                    "Hamur şiştikten sonra fırın tepsisine göre hamuru açıyoruz.\n" +
                    "Hamuru tepsiye koyup üzerine kıymayı koyuyoruz.\n" +
                    "Tekrar tepsiye göre hamuru açıp üzerini kapatıyoruz.\n" +
                    "Üzerine yumurta ve susam ekliyoruz.\n" +
                    "Üzerine bıçakla çizgi çiziyoruz hafiften.\n" +
                    "200 derecede alt üst üzeri kızarana kadar pişiriyoruz.\n" +
                    "Kömbemiz servise hazırdır."
        )
    )

    private lateinit var liste: ListView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Yemek listesini göstermek için ListView kullanımı
        liste = findViewById(R.id.yemekListe)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, yemekListesi)
        liste.adapter = adapter
        // Yemek listesine tıklama işlemi
        liste.setOnItemClickListener { _, _, position, _ ->
            val seciliYemekIsmi = yemekListesi[position]
            val detaylar = yemekDetaylari[seciliYemekIsmi]

            if (detaylar != null) {
                val intent = Intent(this, YemekDetaylari::class.java)
                intent.putExtra("yemekAdi", seciliYemekIsmi)
                intent.putExtra("malzemeler", detaylar.first)
                intent.putExtra("tarif", detaylar.second)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Bu yemek için bilgi bulunamadı.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // Ana menü oluşturma
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.ana_menu, menu)
        return true
    }
    // Menü öğesine tıklama işlemi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.yemek_ekle_secenegi -> yemekEklemePenceresi()
            R.id.oyun_secenegi -> {
                val intent = Intent(this, OyunEkrani::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    // Yemek ekleme penceresini açma işlemi ve bilgileri kaydetme
    private fun yemekEklemePenceresi() {
        val dialogView = layoutInflater.inflate(R.layout.yemek_ekleme, null)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Yemek Ekle")
            .setView(dialogView)
            .setPositiveButton("Kaydet") { _, _ ->
                val yemekAdi = dialogView.findViewById<EditText>(R.id.yemekAdiGirisi).text.toString()
                val malzemeler = dialogView.findViewById<EditText>(R.id.malzemeGirisi).text.toString()
                val tarif = dialogView.findViewById<EditText>(R.id.tarifGirisi).text.toString()

                if (yemekAdi.isNotBlank() && malzemeler.isNotBlank() && tarif.isNotBlank()) {
                    yemekListesi.add(yemekAdi)
                    yemekDetaylari[yemekAdi] = Pair(malzemeler, tarif)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this, "$yemekAdi başarıyla eklendi!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Tüm alanları doldurunuz!", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("İptal", null)
            .create()

        dialog.show()
    }
}
