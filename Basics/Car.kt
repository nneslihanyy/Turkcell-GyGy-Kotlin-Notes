//kotlinde her dosya bir paketin altında tanımlanır
package com.example.kotlin.models

class Car{
    // içi boş bir Car sınıfı oluşturduk
    //eğer erişim belirteci belirtilmediyse default olarak publictir, yani her yerden erişilebilir
    //BluePrint (mavi baskı) gibi düşünebiliriz, Car sınıfı bir şablondur, bu şablondan istediğimiz kadar nesne oluşturabiliriz
    // Classların bir fonksiyonu ve değerleri olur 
    //Properties ve functions

    //Veritabanı işlemleri
    // İş kodları,validasyon yapan class
    //Bir nesneyi temsil eden classlar da mevcut olabilir
    //Car sınıfı bir nesneyi temsil eder, Car sınıfından oluşturulan nesneler araba nesneleridir

    var brand :String =""
    var model :String =""
    var year :Int = 0

    fun rent(){
        println("The car is rented ${brand} ${model} ${year}")
    }
}

