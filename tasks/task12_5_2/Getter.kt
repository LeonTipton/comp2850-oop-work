// Task 12.5.2: class with a custom getter

import java.time.LocalDate

class Person(var _name: String, val birth: LocalDate) {
    constructor(name: String, birth: String):  this(name, LocalDate.parse(birth))
    var isMarried = false

    var name = _name
        get() {
            return field.uppercase()
        }
}

fun main() {
    val nm = readln()
    val person = Person(nm, "1981-12-08")
    println(person.name)
}