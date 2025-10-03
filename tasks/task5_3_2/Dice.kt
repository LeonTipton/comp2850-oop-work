// Task 5.3.2: dice rolling simulation
import kotlin.random.Random

fun rollDice(numberOfDice: Int = 1, sides: Int = 6) {
    if (sides !in setOf(4, 6, 8, 10, 12, 20)) {
        println("Error: cannot have a $sides-sided die")
        return
    }
    if (numberOfDice <= 0) {
        println("Error: number of dice must be positive")
        return
    }
    println("Rolling $numberOfDice d$sides...")
    val results = List(numberOfDice) { Random.nextInt(1, sides + 1) }
    println("You rolled: ${results.joinToString(", ")}")
    println("Total: ${results.sum()}")
}

fun main() {
    rollDice(2, 6) // Roll two 6-sided dice
    rollDice(3, 10) // Roll three 10-sided dice
    rollDice(sides = 20) // Roll one 20-sided die
    rollDice() // Roll one default 6-sided die
}