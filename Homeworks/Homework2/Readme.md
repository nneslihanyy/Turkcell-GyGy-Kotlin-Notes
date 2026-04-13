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

---

## Inheritance (Kalıtım)

Inheritance (Kalıtım), bir sınıfın başka bir sınıftan özellik ve davranışlarını devralmasına olanak tanıyan bir OOP prensibidir.

Bu yaklaşımda:

* Ortak özellikler üst sınıfta (parent/base class) tanımlanır
* Alt sınıflar (child class) bu özellikleri miras alır ve kendi özelliklerini ekler
* Kod tekrarı önlenir ve hiyerarşik yapılar kurulur

---

## Inheritance Neden Kullanılır?

* Kod tekrarını azaltmak için
* Ortak davranışları merkezi bir noktada toplamak için
* Yeni sınıfları mevcut sınıfları genişleterek oluşturmak için
* Hiyerarşik ve düzenli bir yapı kurmak için

---

## Örnek Üzerinden Açıklama

Bu örnekte farklı banka hesap türleri üzerinden kalıtım gösterilmektedir.

Kod dosyası: [Inheritance.kt](Inheritance.kt)

---

### Üst Sınıf Tanımı (open class)

Referans: [Inheritance.kt](Inheritance.kt#L2-L33) 2-33. satırlar

```kotlin
open class BankAccount(private var balance: Double) {

    open fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("$amount TL yatırıldı")
        } else {
            println("Geçersiz miktar")
        }
    }

    open fun withdraw(amount: Double) {
        if (amount <= balance && amount > 0) {
            balance -= amount
            println("$amount TL çekildi")
        } else {
            println("Yetersiz bakiye veya geçersiz miktar")
        }
    }

    fun getBalance(): Double {
        return balance
    }

    protected fun updateBalance(newBalance: Double) {
        balance = newBalance
    }

    open fun showAccountInfo() {
        println("Standart Hesap | Bakiye: $balance TL")
    }
}
```

* `open` anahtar kelimesi, sınıfın kalıtıma açık olduğunu belirtir (Kotlin'de sınıflar varsayılan olarak `final`'dir)
* `open fun` ile metotlar alt sınıflar tarafından override edilebilir hale gelir
* `protected fun updateBalance` yalnızca alt sınıflardan erişilebilir, dışarıdan erişilemez
* `getBalance()` tüm alt sınıflar tarafından miras alınarak kullanılır

---

### Alt Sınıf: Birikim Hesabı (SavingsAccount)

Referans: [Inheritance.kt](Inheritance.kt#L35-L46) 35-46. satırlar

```kotlin
class SavingsAccount(balance: Double, private val interestRate: Double) : BankAccount(balance) {

    fun applyInterest() {
        val interest = getBalance() * interestRate / 100
        deposit(interest)
        println("Faiz uygulandı: $interest TL")
    }

    override fun showAccountInfo() {
        println("Birikim Hesabı | Bakiye: ${getBalance()} TL | Faiz Oranı: %$interestRate")
    }
}
```

* `: BankAccount(balance)` ifadesi ile `BankAccount` sınıfından türetilmiştir
* `interestRate` (faiz oranı) yalnızca bu alt sınıfa özel yeni bir özelliktir
* `applyInterest()` üst sınıfta bulunmayan, yeni eklenen bir metottur
* `showAccountInfo()` üst sınıftaki metot override edilerek özelleştirilmiştir
* `deposit()` ve `getBalance()` gibi metotlar üst sınıftan miras alınarak doğrudan kullanılmıştır

---

### Alt Sınıf: Vadesiz Hesap (CurrentAccount)

Referans: [Inheritance.kt](Inheritance.kt#L48-L62) 48-62. satırlar

```kotlin
class CurrentAccount(balance: Double, private val overdraftLimit: Double) : BankAccount(balance) {

    override fun withdraw(amount: Double) {
        if (amount > 0 && amount <= getBalance() + overdraftLimit) {
            updateBalance(getBalance() - amount)
            println("$amount TL çekildi (Vadesiz Hesap)")
        } else {
            println("Limit aşıldı veya geçersiz miktar")
        }
    }

    override fun showAccountInfo() {
        println("Vadesiz Hesap | Bakiye: ${getBalance()} TL | Ekstra Limit: $overdraftLimit TL")
    }
}
```

* `overdraftLimit` (ekstra çekim limiti) bu alt sınıfa özel bir özelliktir
* `withdraw()` metodu override edilerek, bakiye yetersiz olsa bile limit dahilinde çekim yapılabilir
* `updateBalance()` üst sınıftaki `protected` metot, alt sınıftan erişilerek kullanılmıştır
* `deposit()` metodu değiştirilmeden üst sınıftan miras alınmıştır

---

### Kalıtımın Kullanımı (main)

Referans: [Inheritance.kt](Inheritance.kt#L64-L76) 64-76. satırlar

```kotlin
fun main() {
    val savings = SavingsAccount(1000.0, 5.0)
    savings.showAccountInfo()
    savings.applyInterest()
    savings.showAccountInfo()

    println("---")

    val current = CurrentAccount(500.0, 200.0)
    current.showAccountInfo()
    current.withdraw(600.0)
    current.showAccountInfo()
}
```

* `SavingsAccount` hem üst sınıftan miras aldığı hem de kendine özel metotları kullanır
* `CurrentAccount` bakiyeden fazla çekim yapabilir çünkü `withdraw` metodu özelleştirilmiştir
* Her iki alt sınıf da `BankAccount`'un temel özelliklerini yeniden yazmadan kullanır

---

## Inheritance'ta open ve protected Anahtar Kelimeleri

| Anahtar Kelime | Anlamı |
|---|---|
| `open class` | Sınıfın kalıtıma açık olduğunu belirtir |
| `open fun` | Metodun alt sınıflarda override edilebileceğini belirtir |
| `override fun` | Üst sınıftaki metodun alt sınıfta yeniden tanımlandığını belirtir |
| `protected` | Yalnızca sınıf içinden ve alt sınıflardan erişilebilir |
| `private` | Yalnızca tanımlandığı sınıf içinden erişilebilir |

---

## Polymorphism (Çok Biçimlilik)

Polymorphism (Çok Biçimlilik), aynı metot çağrısının farklı nesneler üzerinde farklı davranışlar sergilemesine olanak tanıyan bir OOP prensibidir.

Bu yaklaşımda:

* Aynı metot adı, farklı sınıflarda farklı şekilde uygulanır
* Üst sınıf referansı ile alt sınıf nesneleri kullanılabilir
* Çalışma zamanında (runtime) hangi metodun çağrılacağına nesnenin gerçek tipi karar verir

---

## Polymorphism Neden Kullanılır?

* Esnek ve genişletilebilir kod yazmak için
* Aynı arayüz üzerinden farklı davranışlar elde etmek için
* Yeni tipler eklerken mevcut kodu değiştirmemek için
* Kodun okunabilirliğini ve bakımını kolaylaştırmak için

---

## Örnek Üzerinden Açıklama

Bu örnekte farklı hesap türlerinin aynı metot çağrısına farklı tepkiler vermesi gösterilmektedir.

Kod dosyası: [Polymorphism.kt](Polymorphism.kt)

---

### Üst Sınıf ve Polimorfik Metotlar

Referans: [Polymorphism.kt](Polymorphism.kt#L2-L29) 2-29. satırlar

```kotlin
open class BankAccount(private var balance: Double) {

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
        }
    }

    open fun withdraw(amount: Double) {
        if (amount <= balance && amount > 0) {
            balance -= amount
        }
    }

    fun getBalance(): Double = balance

    protected fun updateBalance(newBalance: Double) {
        balance = newBalance
    }

    open fun showAccountInfo() {
        println("Standart Hesap | Bakiye: $balance TL")
    }

    open fun applyMonthlyProcess() {
        println("Standart hesap: Aylık işlem uygulanmadı")
    }
}
```

* `showAccountInfo()` ve `applyMonthlyProcess()` metotları `open` olarak tanımlanmıştır
* Bu metotlar alt sınıflarda farklı şekilde uygulanarak çok biçimlilik sağlanır
* Üst sınıf varsayılan davranışı tanımlar, alt sınıflar bunu değiştirir

---

### Farklı Davranış: Birikim Hesabı

Referans: [Polymorphism.kt](Polymorphism.kt#L31-L42) 31-42. satırlar

```kotlin
class SavingsAccount(balance: Double, private val interestRate: Double) : BankAccount(balance) {

    override fun showAccountInfo() {
        println("Birikim Hesabı | Bakiye: ${getBalance()} TL | Faiz: %$interestRate")
    }

    override fun applyMonthlyProcess() {
        val interest = getBalance() * interestRate / 100
        deposit(interest)
        println("Birikim Hesabı: $interest TL faiz eklendi")
    }
}
```

* `applyMonthlyProcess()` çağrıldığında faiz hesaplanır ve bakiyeye eklenir
* Aynı metot adı, bu sınıfta tamamen farklı bir işlem gerçekleştirir

---

### Farklı Davranış: Vadesiz Hesap

Referans: [Polymorphism.kt](Polymorphism.kt#L44-L63) 44-63. satırlar

```kotlin
class CurrentAccount(balance: Double, private val overdraftLimit: Double) : BankAccount(balance) {

    override fun withdraw(amount: Double) {
        if (amount > 0 && amount <= getBalance() + overdraftLimit) {
            updateBalance(getBalance() - amount)
        }
    }

    override fun showAccountInfo() {
        println("Vadesiz Hesap | Bakiye: ${getBalance()} TL | Limit: $overdraftLimit TL")
    }

    override fun applyMonthlyProcess() {
        val fee = 10.0
        if (getBalance() >= fee) {
            updateBalance(getBalance() - fee)
            println("Vadesiz Hesap: $fee TL hesap işletim ücreti kesildi")
        }
    }
}
```

* `applyMonthlyProcess()` çağrıldığında hesap işletim ücreti kesilir
* Aynı metot adı, `SavingsAccount`'ta faiz eklerken burada ücret keser — bu çok biçimliliktir

---

### Çok Biçimliliğin Kullanımı (main)

Referans: [Polymorphism.kt](Polymorphism.kt#L65-L83) 65-83. satırlar

```kotlin
fun main() {
    val accounts: List<BankAccount> = listOf(
        SavingsAccount(1000.0, 5.0),
        CurrentAccount(500.0, 200.0),
        BankAccount(300.0)
    )

    println("=== Hesap Bilgileri ===")
    for (account in accounts) {
        account.showAccountInfo()
    }

    println("\n=== Aylık İşlemler ===")
    for (account in accounts) {
        account.applyMonthlyProcess()
    }

    println("\n=== Güncel Bakiyeler ===")
    for (account in accounts) {
        account.showAccountInfo()
    }
}
```

* `List<BankAccount>` ile tüm hesaplar aynı üst sınıf tipinde tutulur
* `for` döngüsünde `account.showAccountInfo()` çağrıldığında her nesne kendi sınıfına ait metodu çalıştırır
* `account.applyMonthlyProcess()` çağrıldığında: birikim hesabı faiz ekler, vadesiz hesap ücret keser, standart hesap işlem yapmaz
* Bu, çok biçimliliğin özüdür: **aynı çağrı, farklı davranış**

---

## 4 OOP Prensibinin Özet Karşılaştırması

| Prensip | Amaç | Bu Projedeki Örnek |
|---|---|---|
| **Encapsulation** | Veriyi gizleyip kontrollü erişim sağlamak | `balance` değişkeninin `private` olması |
| **Abstraction** | İç detayları gizleyip sadece gerekli davranışları sunmak | `BankTransaction` soyut sınıfı |
| **Inheritance** | Ortak özellikleri miras alarak kod tekrarını önlemek | `SavingsAccount` ve `CurrentAccount` sınıfları |
| **Polymorphism** | Aynı metot çağrısının farklı davranışlar sergilemesi | `applyMonthlyProcess()` metodunun farklı çalışması |
