// Task 15.2.3

// Implement SavingsAccount class here
class SavingsAccount(holder: String, val rate: Double) : BankAccount(holder) {
    init {
        require(rate > 0) { "Interest rate must be a percentage greater than 0" }
    }
    
    fun applyInterest() {
        val interest = balance * rate / 100
        deposit(interest.toInt())
    }
}
