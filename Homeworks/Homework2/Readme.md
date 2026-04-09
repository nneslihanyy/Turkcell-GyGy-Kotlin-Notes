# Object Oriented Programming (OOP)

Nesne Yönelimli Programlama (Object Oriented Programming - OOP), yazılım geliştirirken gerçek dünyadaki varlıkları modellemeye yarayan bir programlama yaklaşımıdır.

OOP yaklaşımında her şey bir "nesne" (object) olarak ele alınır. Bu nesneler:

* Veri (özellikler / properties)
* Davranış (metotlar / functions)

içerir.

Örneğin bir banka hesabı:

* Özellik: bakiye
* Davranış: para yatırma, para çekme

---

## OOP Neden Kullanılır?

OOP yaklaşımı:

* Kod tekrarını azaltır
* Okunabilirliği artırır
* Büyük projeleri yönetilebilir hale getirir
* Gerçek dünya problemlerini modellemeyi kolaylaştırır

---

## OOP'nin 4 Temel Prensibi

Bu projede aşağıdaki OOP prensipleri ele alınmaktadır:

1. Encapsulation (Kapsülleme)
2. Abstraction (Soyutlama)
3. Inheritance (Kalıtım)
4. Polymorphism (Çok Biçimlilik)

---

## Proje Yaklaşımı

Bu projede tüm OOP kavramları bir banka sistemi üzerinden açıklanmaktadır.

Gerçek bir banka uygulamasında:

* Hesap verilerinin korunması
* İşlemlerin belirli kurallara bağlı olması
* Farklı hesap türlerinin bulunması

gibi durumlar yer alır.

Bu nedenle banka sistemi, OOP kavramlarını açıklamak için uygun bir örnek sunmaktadır.

---

## Encapsulation (Kapsülleme)

Encapsulation (Kapsülleme), bir sınıfın içindeki verilerin dış dünyadan gizlenmesi ve bu verilere yalnızca kontrollü yöntemler aracılığıyla erişilmesini sağlayan bir OOP prensibidir.

Bu yaklaşımda:

* Veri doğrudan erişime kapatılır
* Sadece belirli metotlar üzerinden işlem yapılır
* Veri güvenliği sağlanır

---

## Encapsulation Neden Kullanılır?

* Veriyi korumak için
* Hatalı kullanımın önüne geçmek için
* İş kurallarını zorunlu kılmak için
* Daha güvenli ve sürdürülebilir kod yazmak için

---

## Örnek Üzerinden Açıklama

Bu örnekte bir banka hesabı üzerinden kapsülleme gösterilmektedir.

Kod dosyası: [Encapsulation.kt](Encapsulation.kt)

---

### Verinin Gizlenmesi (private)

Referans: [Encapsulation.kt](Encapsulation.kt#L2) 2. satır

```kotlin
class BankAccount(private var balance: Double)
```

* `balance` değişkeni `private` olarak tanımlanmıştır
* Bu değişkene sınıf dışından doğrudan erişilemez
* Veri yalnızca sınıf içinden kontrol edilir

---

### Kontrollü Veri Güncelleme (deposit)

Referans: [Encapsulation.kt](Encapsulation.kt#L4-L12) 4-11. satırlar

```kotlin
fun deposit(amount: Double) {                  
        if (amount > 0) {                          
            balance += amount                      
            println("$amount TL yatırıldı")        
        } else {
            println("Geçersiz miktar")            
        }
    }
```

* Negatif veya geçersiz değerlerin eklenmesi engellenir
* Veri yalnızca belirli kurallar çerçevesinde güncellenir

---

### Güvenli Para Çekme (withdraw)

Referans: [Encapsulation.kt](Encapsulation.kt#L13-L21) 13-20. satırlar

```kotlin
 fun withdraw(amount: Double) {                 
        if (amount <= balance && amount > 0) {     
            balance -= amount                     
            println("$amount TL çekildi")          
        } else {
            println("Yetersiz bakiye veya geçersiz miktar") 
        }
    }
```

* Hesapta yeterli bakiye olup olmadığı kontrol edilir
* Geçersiz işlemler engellenir

---

### Veriye Kontrollü Erişim (getter)

Referans: [Encapsulation.kt](Encapsulation.kt#L22-L25) 22-24. satırlar

```kotlin
fun getBalance(): Double {
    return balance
}
```

* `balance` değişkenine doğrudan erişim yoktur
* Veri yalnızca bu metot aracılığıyla okunabilir

---

## Neden setBalance Yok?

Encapsulation prensibine uygun olarak, BankAccount sınıfında doğrudan bakiye değiştirmeye izin veren bir setter (setBalance) eklenmemiştir.

Bunun nedeni:

* Veriyi korumak: Kullanıcıların bakiyeyi sınıf dışından doğrudan değiştirmesi, hesabın iç tutarlılığını bozabilir.
* İş kurallarını zorunlu kılmak: Para yatırma ve çekme işlemleri, deposit ve withdraw metotları üzerinden gerçekleşir. Bu metotlar, negatif değerleri veya yetersiz bakiyeyi engeller.
* Kontrollü erişim sağlamak: Getter (getBalance) yalnızca bakiyeyi okumaya izin verir, değişiklikler kontrollü metotlar üzerinden yapılır.

Eğer setter eklenirse, kullanıcı kuralları bypass edebilir ve kapsülleme prensibi ihlal edilir. Bu nedenle, setter yerine kontrollü metotlar kullanılmıştır.
