// Task 5.4.1: string extension function
val String.tooLong: Boolean get() = this.length > 20

fun main() {
    val testStrings = listOf(
        "Short string",
        "This is a reasonably long string",
        "This string is definitely way too long to be acceptable"
    )

    for (str in testStrings) {
        if (str.tooLong) {
            println("The string \"$str\" is too long.")
        } else {
            println("The string \"$str\" is acceptable.")
        }
    }
} 