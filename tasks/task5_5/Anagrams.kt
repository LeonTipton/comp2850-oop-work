// Task 5.1.1: anagram checking using a function
infix fun String.anagramOf(str: String) = this.lowercase().toList().sorted() == str.lowercase().toList().sorted()

fun main() {
    print("Enter the first string: ")
    val first = readln()
    
    print("Enter the second string: ")
    val second = readln()
    
    if (first anagramOf second) {
        println("\"$first\" and \"$second\" are anagrams.")
    } else {
        println("\"$first\" and \"$second\" are not anagrams.")
    }
}