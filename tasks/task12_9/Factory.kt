// Task 12.9: class implementing the Static Factory Method pattern

import java.time.LocalDate

class Person private constructor(val name: String, val birth: LocalDate) {
    companion object Factory {
        // constructor(name: String, birth: String):  this(name, LocalDate.parse(birth))
        private val names = mutableSetOf<String>()

        fun create(name:String, birth: LocalDate): Person {
            require(name.isNotBlank()) { "Name cannot be blank" }
            require(name !in names) { "Name '$name' is already taken" }
            names.add(name)
            return Person(name, birth)
        }
    }
}

fun main() {
    val person1 = Person.create("alice", LocalDate.parse("1918-12-07"))
    val person2 = Person.create("alice", LocalDate.parse("1918-12-05"))
}