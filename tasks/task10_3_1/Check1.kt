// Task 10.3.1: example of an explicit null check

fun printReversed(text: String) {
    val result = text.reversed().uppercase()
    println("Result: $result")
}

fun main() {
    print("Enter a string: ")
    val input = readLine()

    println("Input: $input")
    when (input) {
        null -> println("Result: null")
        else -> printReversed(input)
    }
}
