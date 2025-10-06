fun String.howMany(include: (Char) -> Boolean): Int {
    var count = 0
    for (character in this) {
        if (include(character)) {
            count += 1
        }
    }
    return count
}

fun main() {
    print("Enter a string: ")
    val str = readln()
    println("Number of characters: ${str.howMany { true }}")
    println("Number of non-whitespace characters: ${str.filter { !it.isWhitespace() }.howMany { true }}")
}