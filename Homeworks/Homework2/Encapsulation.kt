
class BankAccount(private var balance: Double) {   

    fun deposit(amount: Double) {                  
        if (amount > 0) {                          
            balance += amount                      
            println("$amount TL yatırıldı")        
        } else {
            println("Geçersiz miktar")            
        }
    }

    fun withdraw(amount: Double) {                 
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
}

fun main() {                                      
    val account = BankAccount(100.0)               

    account.deposit(50.0)                          
    account.withdraw(30.0)                         

    println("Güncel bakiye: ${account.getBalance()}") 
}