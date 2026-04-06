// Kotlin: JVM tabanlı bir programlama dilidir.
// Java'nın modern alternatifi olarak kabul edilir.
// Backend, web ve multiplatform geliştirme yapılabilir.
// Android’in resmi dilidir ama sadece Android için kullanılmaz.
// Java’ya göre daha az kodla aynı işi yapar (boilerplate çok azdır).

// Terminal notları:
// Terminal komutları yapay zekaya çalıştırılmamalıdır.
// focus folder: kodun çalıştırılacağı klasördür.
// cd: klasör değiştirme (change directory)
// cd .. : bir üst klasöre çıkma
// ls: klasördeki dosyaları listeler

// Derleme ve çalıştırma:
// kotlinc main.kt -include-runtime -d main.jar
// jar: Java tarafından çalıştırılabilen executable dosyalardır.
// Çalıştırma: java -jar main.jar

fun main() {

    // Scope: kapsama alanı
    println("Hello")

    // Değişkenler:
    // Programın akışında RAM'de tutulan, isimle erişilen ve değeri değişebilen yapılardır.
    // Kotlin’de noktalı virgül zorunlu değildir.

    var a = 5  // a değişkenine 5 değeri atandı
    println(a)

    // INT -> tamsayı veri tipi
    a = 6
    println(6)

    var name = "Neslihan"
    println(name)

    var surname: String = "Yağmurca"
    println(surname)

    // val ile tanımlanan değişkenler sabittir (immutable), değeri değiştirilemez
    val b: Int = 10
    // b = 11 // Hata: val yeniden atanamaz

    // Kotlin null safety özelliğine sahiptir.
    // Varsayılan olarak değişkenler null değer alamaz.

    var surname2: String? = "Bal"
    // ? işareti null alabileceğini belirtir
    // surname2 = null // hata olmaz
    println(surname2)

    var surname3: String? = "Bal2"
    surname3 = null
    println(surname3) // null çıktı alınabilir

    // Nullable değişken kullanımı:
    // surname3.length -> hata
    // surname3!!.length -> zorla null kullanımı (riskli, NullPointerException)
    // surname3?.length -> güvenli kullanım

    // String interpolation: değişkenleri string içinde kullanma
    var nameSurname: String = "$name $surname  ${20 + 5}"
    println(nameSurname)

    // Array (dizi)
    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    var students: Array<String> = arrayOf("neslihan", "berkay", "bal")

    // Array erişimi index bazlıdır
    println(numbers[0])
    println(students[1])

    students[2] = "yağmurca"
    println(students[2])

    // Listeler arraylere göre daha esnek yapılardır
    val numberList = listOf(1, 2, 3, 4, 5)
    // numberList.add(6) -> ekleme yapılamaz (immutable)

    val numberListMutable = mutableListOf(1, 2, 3, 4, 5, 6)
    numberListMutable.add(7)

    // val: referans değişmez
    // mutable yapı: içeriği değişebilir

    // Control Flow
    println(10 + 20)
    println(10 == 20)

    val yas: Int = 18

    // if-else yapısı:
    // İlk sağlanan koşul çalışır
    if (yas >= 18) {
        println("Yetki verildi.")
    } else if (yas == 18) {
        println("Ay kontrolü yapılıyor.")
    } else {
        println("Yetki verilmedi.")
    }

    // when (switch-case alternatifi)
    val gun: Int = 3

    when (gun) {
        1 -> println("Pazartesi")
        2 -> println("Salı")
        3 -> println("Carsamba")
        else -> println("Geçersiz gün")
    }

    when (gun) {
        1, 2, 3, 4, 5 -> println("Hafta içi")
        6, 7 -> println("Hafta sonu")
        else -> println("Geçersiz gün")
    }

    // if ve when aynı zamanda expression olarak kullanılabilir
    val sonuc: String = if (yas >= 18) "Yetki verildi" else "Yetki verilmedi"

    val gunIsmi: String = when (gun) {
        1 -> "Pazartesi"
        2 -> "Salı"
        3 -> "Carsamba"
        else -> "Geçersiz gün"
    }

    // Döngüler (loops)

    for (i in 1..5) {
        println(i)
    }

    for (i in 0..20 step 2) {
        println(i)
    }

    for (i in 10 downTo 0) {
        println(i)
    }

    for (i in 0 until 5) {
        println(i)
    }

    // continue ve break kullanımı

    val studentList = listOf("Halit", "Ahmet", "Mehmet", "Nazlı", "İsmail", "Eren")

    for (student in studentList) {
        // "Ahmet" ismini atla
        if (student == "Ahmet")
            continue
        println(student)
    }

    println("*** Break ***")

    for (student in studentList) {
        if (student == "Ahmet") {
            println("Ahmet bulundu, döngü sonlandırılıyor.")
            break // döngüyü tamamen bitirir
        }
        println(student)
    }
}