class Car{
    // içi boş bir Car sınıfı oluşturduk
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
}

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

    var car2 : Car = Car()
    car2.brand = "Honda"
    car2.model = "Civic"
    car2.year = 2019
    println(car2) 
    println(car) // Car@6bc7c054 gibi bir çıktı verir, nesnenin bellek adresini gösterir
}