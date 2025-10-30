// Task 17.3: creating & using interfaces

// Add Printable interface here
interface Printable {
    fun print()
}
// Add Document class here
class Document(val filename: String) : Printable {
    override fun print() = println("Printing $filename")
}

fun main() {
    val item: Printable = Document("info.txt")
    item.print()
}
