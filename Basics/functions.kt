fun main() {

    // Fonksiyon çağırma:
    // Tanımladığımız fonksiyonları isimleriyle çağırarak çalıştırırız.
    selamVer()

    // Parametreli fonksiyon çağırma:
    // Fonksiyona veri göndererek çalıştırırız.
    selamVer2("Ahmet")

    // Fonksiyonlardan değer döndürme (return):
    // Fonksiyon sonucu bir değişkene atanabilir.

    var not1 = notHesapla(85,"Halit") // sonucu al ve ekrana yazdır
    var not2 = notHesapla(72) // isim verilmediği için default değer kullanılacak (mail atmak gibi düşün)
    var not3 = notHesapla(30, "Mehmet") // düşük not örneği (sms atmak gibi düşün)

    // Named Arguments:
    // Parametrelerin sırasını karıştırmadan isimleriyle değer verebiliriz.
    // Bu sayede okunabilirlik artar ve hata ihtimali azalır.
    var not4 = notHesapla(isim="Ayse", not=95)

    // Sonuçları ekrana yazdırma
    println(not1)
    println(not2)
    println(not4)

    // not2'yi email at (örnek senaryo)
    // not3'ü sms at (örnek senaryo)
}

// Programlamada fonksiyon:
// Aynı işi birden fazla yerde yapıyorsak tekrar yazmak yerine,
// bir kez tanımlayıp istediğimiz yerde çağırmak daha doğru ve temiz bir yaklaşımdır (DRY prensibi).

// Fonksiyonlar:
// Belirli bir işi yapan, isimlendirilmiş kod bloklarıdır.
// Kod tekrarını azaltır, okunabilirliği artırır ve bakım kolaylığı sağlar.

fun selamVer() {
    // Parametresiz fonksiyon:
    // Dışarıdan veri almaz, sadece kendi içinde işlem yapar.
    println("Merhaba")
}

// Parametreli fonksiyon:
// Dışarıdan veri alarak çalışır.
fun selamVer2(isim:String) {
    // String interpolation ile değişkeni yazdırıyoruz
    println("Merhaba $isim")
}

// Fonksiyonlar:
// 1. Değer döndürmeyebilir (Unit / void)
// 2. Değer döndürebilir (return)

// Default parameter:
// Fonksiyon çağrılırken parametre verilmezse,
// burada tanımlanan varsayılan değer kullanılır.
fun notHesapla(not:Int, isim:String="Ogrenci"): String {

    // when ifadesi:
// Bir değeri birden fazla koşula göre kontrol etmek için kullanılır.
// switch-case mantığına benzer ama daha güçlüdür.

    return when(not){

        // in operatörü:
// Belirli bir aralıkta olup olmadığını kontrol eder.

        in 90..100 -> "$isim AA"   // 90-100 arası
        in 80..89 -> "$isim BA"
        in 70..79 -> "$isim BB"
        in 60..69 -> "$isim CB"
        in 50..59 -> "$isim CC"
        in 40..49 -> "$isim DC"
        in 30..39 -> "$isim DD"
        in 0..29 -> "$isim FF"

        // Hiçbir aralığa girmezse:
        else -> "$isim Geçersiz not"
    }
}