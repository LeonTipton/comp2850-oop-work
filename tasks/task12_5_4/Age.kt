// Task 12.5.4: class with a computed property

import java.time.LocalDate
import java.time.temporal.ChronoUnit.YEARS

class Person(var name: String, val birth: LocalDate) {
    constructor(_name: String, birth: String):  this(_name, LocalDate.parse(birth))
    var isMarried = false
    val age get() = YEARS.between(birth, LocalDate.now()).toInt()
}

fun main() {
    val p = Person("name", "1974-01-08")
    println(p.age)
}