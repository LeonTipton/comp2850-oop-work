// Task 12.5.3: class with a custom setter

import java.time.LocalDate

class Person(_name: String, val birth: LocalDate) {
    constructor(_name: String, birth: String):  this(_name, LocalDate.parse(birth))

    var isMarried = false

    var name = _name
        set(value) {
            require(value.isNotBlank()) { "Name cannot be blank" }
            field = value
        }
}

fun main() {
    val nm = readln()
    val person = Person(nm, "1981-12-08")
    person.name = ""
    println(person.name)
}