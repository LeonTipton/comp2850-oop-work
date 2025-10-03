import kotlin.random.Random

fun rollDie(sides: Int = 6) {
    if (sides in setOf(4, 6, 8, 10, 12, 20)) {
        println("Rolling a d$sides...")
        val result = Random.nextInt(1, sides + 1)
        println("You rolled $result")
    }
    else {
        println("Error: cannot have a $sides-sided die")
    }
}

fun readInt(prompt: String): Int {
    while (true) {
        print(prompt)
        val input = readln()
        val number = input.toIntOrNull()
        if (number != null) {
            return number
        }
        println("Error: '$input' is not a valid number")
    }
}

fun main() {
    val sides = readInt("Enter the number of sides for the die (4, 6, 8, 10, 12, or 20): ")
    rollDie(sides)
    rollDie() // Roll a default 6-sided die
}