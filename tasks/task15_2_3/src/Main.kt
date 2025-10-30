// Task 15.2.3

fun main() {
    val savings = SavingsAccount("LT", 1.8)
    savings.deposit(1250)

    repeat(5) {
        savings.applyInterest()
    }
    savings.withdraw(50)
    println("You have accrued £${savings.balance} in savings")
}
