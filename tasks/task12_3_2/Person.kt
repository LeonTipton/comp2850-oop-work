// Task 12.3.2: Person class, with a secondary constructor
import java.time.LocalDate

class Person(var name: String, val birth: LocalDate) {
    constructor(name: String, birth: String):  this(name, LocalDate.parse(birth))
    var isMarried = false
}

fun main() {
    val date = "1997-08-23"
    val person = Person("Adam West", date)
    println(person.name)
    println(person.birth)
}