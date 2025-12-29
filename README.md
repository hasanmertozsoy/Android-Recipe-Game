Bu proje, yöresel yemek tariflerinin yönetildiği dinamik bir rehber ile eğlenceli bir kelime bulmaca oyununu tek bir çatı altında toplayan Kotlin tabanlı bir Android uygulamasıdır. Kullanıcı dostu arayüzü ve yerel veri saklama özellikleri ile pratik bir mobil deneyim sunar.

##  Özellikler

* **Güvenli Giriş Sistemi:** `SharedPreferences` kullanılarak oluşturulmuş, "Beni Hatırla" fonksiyonuna sahip kullanıcı giriş ekranı.
* **Dinamik Tarif Yönetimi:**
    * Geleneksel yemeklerin listelenmesi ve detaylı tarif görüntüleme.
    * Kullanıcıların kendi tariflerini (ad, malzeme, yapılış) ekleyebildiği dinamik veri girişi.
* **Kelime Bulmaca Oyunu:** Meyve isimlerini karıştıran algoritmaya dayalı, puan sistemli interaktif mini oyun.
* **Kullanıcı Arayüzü:** Özel `Splash Screen` (Geri sayımlı açılış ekranı), `ListView` ile veri listeleme ve `AlertDialog` entegrasyonları.

##  Teknik Altyapı

* **Dil:** Kotlin
* **Minimum SDK:** API 27 (Android 8.1)
* **Target SDK:** API 34
* **Veri Saklama:** SharedPreferences (Giriş bilgileri için)
* **Bileşenler:** Activity Lifecycle, Intents, ListView, CountDownTimer

##  Kurulum

1.  Projeyi klonlayın:
    ```bash
    git clone [https://github.com/kullaniciadi/repo-adi.git](https://github.com/kullaniciadi/repo-adi.git)
    ```
2.  Android Studio'yu açın ve **File > Open** yolunu izleyerek proje klasörünü seçin.
3.  Gradle senkronizasyonunun bitmesini bekleyin.
4.  Bir emülatör veya fiziksel cihaz seçerek **Run** (Shift+F10) tuşuna basın.

##  Test Bilgileri

Uygulama özelliklerini ve giriş ekranını test etmek için tanımlı varsayılan bilgiler:

* **Kullanıcı Adı:** `hasanmert`
* **Şifre:** `123`
