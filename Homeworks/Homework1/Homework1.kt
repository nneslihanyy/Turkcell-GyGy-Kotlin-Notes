fun main() {

    var kayitliKullanici: String? = null
    var kayitliSifre: String? = null
    var bakiye = 0.0

    while (true) {

        println("\n--- ANA MENÜ ---")
        println("1- Kayıt Ol")
        println("2- Giriş Yap")
        println("3- Çıkış")

        print("Seçiminiz: ")
        val secim = readLine()?.toIntOrNull()

        when (secim) {

            //KAYIT
            1 -> {
                print("Kullanıcı adı oluştur: ")
                val kullanici = readLine()

                print("Şifre oluştur: ")
                val sifre = readLine()

                if (kullanici != null && sifre != null) {
                    kayitliKullanici = kullanici
                    kayitliSifre = sifre
                    bakiye = 1000.0 // başlangıç bakiyesi
                    println("Kayıt başarılı!")
                } else {
                    println("Geçersiz giriş!")
                }
            }

            //GİRİŞ
            2 -> {
                print("Kullanıcı adı: ")
                val kullanici = readLine()

                print("Şifre: ")
                val sifre = readLine()

                if (kullanici == kayitliKullanici && sifre == kayitliSifre) {
                    println("Giriş başarılı!")

                    //  BANKA MENÜSÜ
                    while (true) {
                        println("\n--- BANKA MENÜ ---")
                        println("1- Bakiye Görüntüle")
                        println("2- Para Yatır")
                        println("3- Para Çek")
                        println("4- Çıkış Yap")

                        print("Seçiminiz: ")
                        val islem = readLine()?.toIntOrNull()

                        when (islem) {

                            1 -> bakiyeGoster(bakiye)

                            2 -> {
                                print("Yatırılacak miktar: ")
                                val miktar = readLine()?.toDoubleOrNull()

                                if (miktar != null && miktar > 0)
                                    bakiye = paraYatir(bakiye, miktar)
                                else
                                    println("Geçersiz miktar!")
                            }

                            3 -> {
                                print("Çekilecek miktar: ")
                                val miktar = readLine()?.toDoubleOrNull()

                                if (miktar != null && miktar > 0)
                                    bakiye = paraCek(bakiye, miktar)
                                else
                                    println("Geçersiz miktar!")
                            }

                            4 -> {
                                println("Hesaptan çıkış yapıldı.")
                                break
                            }

                            else -> println("Geçersiz seçim!")
                        }
                    }

                } else {
                    println("Hatalı kullanıcı adı veya şifre!")
                }
            }

            //ÇIKIŞ
            3 -> {
                println("Uygulamadan çıkılıyor...")
                break
            }

            else -> println("Geçersiz seçim!")
        }
    }
}

fun bakiyeGoster(bakiye: Double) {
    println("Bakiyeniz: $bakiye TL")
}

fun paraYatir(bakiye: Double, miktar: Double): Double {
    val yeniBakiye = bakiye + miktar
    println("$miktar TL yatırıldı.")
    return yeniBakiye
}

fun paraCek(bakiye: Double, miktar: Double): Double {
    return if (miktar <= bakiye) {
        println("$miktar TL çekildi.")
        bakiye - miktar
    } else {
        println("Yetersiz bakiye!")
        bakiye
    }
}