
package com.example.kotlin
// import com.example.kotlin.models.Car // Car sınıfını kullanmak için import ediyoruz
import com.example.kotlin.models.Car
fun main(){
    // Car sınıfından bir nesne oluşturduk
    // O nesneye car adını verdik, car nesnesi Car sınıfının bir örneğidir
    var car : Car = Car()
    val car1: Car = Car()
    // car1 bir instance (örnek) dir Car sınıfının, car1 nesnesi Car sınıfının bir örneğidir
    car1.brand = "Toyota"
    car1.model = "Corolla"
    car1.year = 2020
    println(car1) 
    car1.rent()

    var car2 : Car = Car()
    car2.brand = "Honda"
    car2.model = "Civic"
    car2.year = 2019
    println(car2) 
    car2.rent()
    println(car) // Car@6bc7c054 gibi bir çıktı verir, nesnenin bellek adresini gösterir
}