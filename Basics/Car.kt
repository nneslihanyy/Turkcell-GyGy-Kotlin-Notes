//kotlinde her dosya bir paketin altında tanımlanır
package com.example.kotlin.models

// bu şekilde tanımlanan bir sınıfın özelliklerine (properties) ve fonksiyonlarına (functions) erişmek için o sınıfın bir nesnesini oluşturmak gerekir
class Car(
var brand : String = "",
var model : String = "",
private var year : Int = 0
){
    // içi boş bir Car sınıfı oluşturduk
    //eğer erişim belirteci belirtilmediyse default olarak publictir, yani her yerden erişilebilir
    //BluePrint (mavi baskı) gibi düşünebiliriz, Car sınıfı bir şablondur, bu şablondan istediğimiz kadar nesne oluşturabiliriz
    // Classların bir fonksiyonu ve değerleri olur 
    //Properties ve functions

    //Veritabanı işlemleri
    // İş kodları,validasyon yapan class
    //Bir nesneyi temsil eden classlar da mevcut olabilir
    //Car sınıfı bir nesneyi temsil eder, Car sınıfından oluşturulan nesneler araba nesneleridir

    //var brand :String =""
    // var model :String =""
    //var year :Int = 0

    init {
        // init bloğu, sınıfın bir nesnesi oluşturulduğunda yani constructor çalıştırıldığında çalıştırılan bir bloktur
        println("Car class is initialized")
    }

    fun rent(){
        println("The car is rented ${brand} ${model} ${year}")
    }

    fun getYear(): Int {
        return year
    }
    fun setYear(year: Int) {
       if(year <1990 || year > 2026){
        println("Invalid year")
    }
  else{this.year = year}
        
    
    }
}

//class içi değişken manuel yönetilmelidir.
class Car2 {
    constructor(brand: String, model: String, year: Int) {
        println("Car2 class is initialized")
    }

    fun rent(){
        println("The car is rented ")
    }
}

fun main() {

    var car1 : Car = Car("Toyota", "Camry", 2020) // Constructor (yapıcı) fonksiyonu, Car sınıfından bir nesne oluşturur
    car1.rent() // Car sınıfının rent fonksiyonunu çağırır, The car is rented  0 çıktısı verir çünkü brand, model ve year değerleri boş ve sıfır olarak atanmıştır
    println(car1.brand) // get >> Toyota çıktısı verir
    car1.brand = "Honda" // set >> brand değerini Honda olarak değiştirir
    println(car1.brand) // get >> Honda çıktısı verir
    //get set olmazsa year değerini değiştiremezdik, çünkü year değişkeni private olarak tanımlanmıştır, sadece Car sınıfı içinden erişilebilir, dışarıdan erişilemez
    // car1.year = 2021 
    //println(car1.year) //Car.kt:54:14: error: cannot access 'var year: Int': it is private in 'com.example.kotlin.models.Car'.
    println(car1.getYear()) // get >> 2020 çıktısı verir çünkü year değeri 2020 olarak atanmıştır
    car1.setYear(2021)
    println(car1.getYear()) 
    car1.setYear(1980) // Invalid year çıktısı verir çünkü 1980 geçersiz bir yıl olarak kabul edilir
    println(car1.getYear()) // get >> 2021 çıktısı verir çünkü year değeri 2021 olarak atanmıştır, 1980 geçersiz bir yıl olarak kabul edildiği için year değeri değişmemiştir
   // car2.rent() // The car is rented  0 çıktısı verir çünkü brand, model ve year değerleri boş ve sıfır olarak atanmıştır
}

/*
1 hafta var => haftaya salı 18.30a kadar
OOP Konseptlerini
Encapsulation (Kapsülleme),
Abstraction (Soyutlama),
Inheritance (Kalıtım),
Polymorphism (Çok Biçimlilik)
 terimlerini bir markdown dosyasında açıklayınız ve örneklerle anlatınız.
 referanslarla .kt dosyalarını readme de belirtin, OOP konseptlerini kullanarak anlatımı güçlendiriniz.
*/