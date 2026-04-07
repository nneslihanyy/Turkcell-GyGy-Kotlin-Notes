//kotlinde her dosya bir paketin altında tanımlanır
package com.example.kotlin.models

// bu şekilde tanımlanan bir sınıfın özelliklerine (properties) ve fonksiyonlarına (functions) erişmek için o sınıfın bir nesnesini oluşturmak gerekir
class Car(
var brand : String = "",
var model : String = "",
var year : Int = 0
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
    var car2 : Car2 = Car2("Honda", "Civic", 2019)
    car2.rent() // The car is rented  0 çıktısı verir çünkü brand, model ve year değerleri boş ve sıfır olarak atanmıştır
}

