// Task 10.3.2: another example of an explicit null check

fun printReversed(text: String?) {
    println("Result: ${text?.let { it.reversed().uppercase() }}")
}

fun main() {
    print("Enter a string: ")
    val input = readLine()

    println("Input: $input")
    printReversed(input)
}
