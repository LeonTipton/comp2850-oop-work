// Task 12.3.2: Person class, with a secondary constructor
import java.time.LocalDate

class Person(var name: String, val birth: LocalDate) {
    constructor(name: String, birth: String):  this(name, LocalDate.parse(birth))

    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
    }

    var isMarried = false
}

fun main() {
    val name = readln()
    val date = readln()
    val person = Person(name, date)
    println(person.name)
    println(person.birth)
}