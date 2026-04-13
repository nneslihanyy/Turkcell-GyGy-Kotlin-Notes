
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
