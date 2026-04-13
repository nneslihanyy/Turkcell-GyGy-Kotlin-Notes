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

---

## Abstraction (Soyutlama)

Abstraction (Soyutlama), bir sınıfın yalnızca önemli özelliklerini dışarıya sunup, karmaşık iç detayları gizlemeye yarayan bir OOP prensibidir.

Bu yaklaşımda:

* Ortak davranışlar soyut bir sınıfta tanımlanır
* Alt sınıflar, soyut metotları kendi ihtiyaçlarına göre uygular
* Kullanıcı, detayları bilmeden sadece ortak arayüzü kullanır

---

## Abstraction Neden Kullanılır?

* Kodun karmaşıklığını azaltmak için
* Ortak davranışları tek bir noktada toplamak için
* Alt sınıfların yalnızca farklı olan kısımları uygulamasını sağlamak için
* Daha esnek ve genişletilebilir yapılar kurmak için

---

## Örnek Üzerinden Açıklama

Bu örnekte banka işlemleri üzerinden soyutlama gösterilmektedir.

Kod dosyası: [Abstraction.kt](Abstraction.kt)

---

### Soyut Sınıf Tanımı (abstract class)

Referans: [Abstraction.kt](Abstraction.kt#L2-L12) 2-12. satırlar

```kotlin
abstract class BankTransaction {

    abstract fun execute(amount: Double)

    fun validateAmount(amount: Double): Boolean {
        return amount > 0
    }

    fun logTransaction(type: String, amount: Double) {
        println("İşlem: $type | Tutar: $amount TL")
    }
}
```

* `BankTransaction` soyut bir sınıftır ve doğrudan nesnesi oluşturulamaz
* `execute` metodu `abstract` olarak tanımlanmıştır, her alt sınıf bu metodu kendine göre uygular
* `validateAmount` ve `logTransaction` metotları tüm alt sınıflar tarafından ortaklaşa kullanılır
* Ortak davranışlar burada tek bir yerde toplanmıştır

---

### Somut Uygulama: Para Yatırma (DepositTransaction)

Referans: [Abstraction.kt](Abstraction.kt#L14-L23) 14-23. satırlar

```kotlin
class DepositTransaction(private val account: BankAccount) : BankTransaction() {

    override fun execute(amount: Double) {
        if (validateAmount(amount)) {
            account.deposit(amount)
            logTransaction("Para Yatırma", amount)
        } else {
            println("Geçersiz yatırma tutarı")
        }
    }
}
```

* `BankTransaction` soyut sınıfından türetilmiştir
* `execute` metodu `override` edilerek para yatırma işlemi uygulanmıştır
* Üst sınıftaki `validateAmount` ve `logTransaction` metotları yeniden yazılmadan kullanılmıştır

---

### Somut Uygulama: Para Çekme (WithdrawTransaction)

Referans: [Abstraction.kt](Abstraction.kt#L25-L34) 25-34. satırlar

```kotlin
class WithdrawTransaction(private val account: BankAccount) : BankTransaction() {

    override fun execute(amount: Double) {
        if (validateAmount(amount)) {
            account.withdraw(amount)
            logTransaction("Para Çekme", amount)
        } else {
            println("Geçersiz çekme tutarı")
        }
    }
}
```

* `DepositTransaction` ile aynı soyut sınıftan türetilmiştir
* Yalnızca farklı olan kısım (`withdraw`) uygulanmıştır
* Ortak doğrulama ve loglama işlemleri değiştirilmeden tekrar kullanılmıştır

---

### Soyutlamanın Kullanımı (main)

Referans: [Abstraction.kt](Abstraction.kt#L36-L44) 36-44. satırlar

```kotlin
fun main() {
    val account = BankAccount(500.0)

    val deposit: BankTransaction = DepositTransaction(account)
    val withdraw: BankTransaction = WithdrawTransaction(account)

    deposit.execute(200.0)
    withdraw.execute(100.0)

    println("Güncel bakiye: ${account.getBalance()} TL")
}
```

* `deposit` ve `withdraw` değişkenleri `BankTransaction` tipinde tanımlanmıştır
* Kullanıcı, alt sınıfların iç detaylarını bilmeden sadece `execute` metodunu çağırır
* Bu yaklaşım sayesinde yeni işlem türleri eklemek (örn. transfer) mevcut kodu değiştirmeden mümkündür

---

## Abstraction ve Encapsulation Farkı

Bu iki prensip birbirine benzer görünse de farklı amaçlara hizmet eder:

* **Encapsulation**: Verinin gizlenmesi ve kontrollü erişim sağlanmasıyla ilgilidir. `balance` değişkeninin `private` olması buna örnektir.
* **Abstraction**: Karmaşık iç yapının gizlenmesi ve yalnızca gerekli davranışların dışarıya sunulmasıyla ilgilidir. `BankTransaction` soyut sınıfı buna örnektir.

Kısacası, encapsulation "veriyi" gizlerken, abstraction "işleyişi" gizler.
