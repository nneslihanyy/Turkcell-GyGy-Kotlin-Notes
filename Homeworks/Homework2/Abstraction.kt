
abstract class BankTransaction {

    abstract fun execute(amount: Double)

    fun validateAmount(amount: Double): Boolean {
        return amount > 0
    }

    fun logTransaction(type: String, amount: Double) {
        println("İşlem: $type | Tutar: $amount TL")
    }
}

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

fun main() {
    val account = BankAccount(500.0)

    val deposit: BankTransaction = DepositTransaction(account)
    val withdraw: BankTransaction = WithdrawTransaction(account)

    deposit.execute(200.0)
    withdraw.execute(100.0)

    println("Güncel bakiye: ${account.getBalance()} TL")
}
