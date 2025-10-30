// Task 15.3: method overriding & dynamic binding
open class Person {
    open fun speak() {
        println("I am a Person")
    }
}

class Student(val degree: String) : Person() {
    override fun speak() {
        println("I am a Student, studying $degree")
    }
}

fun main() {
    val p = Person()
    p.speak()

    val s = Student("Computer Science")
    s.speak()

    val p2: Person = Student("Maths")
    p2.speak()
}
