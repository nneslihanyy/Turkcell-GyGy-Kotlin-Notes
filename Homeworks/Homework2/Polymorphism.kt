
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
