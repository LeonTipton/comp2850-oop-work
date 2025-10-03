// Task 5.2.1: geometric properties of circles
import kotlin.math.PI
import kotlin.math.pow

fun circleArea(radius: Double) = PI * radius.pow(2)
fun circleCircumference(radius: Double) = 2 * PI * radius

fun readDouble(prompt: String): Double {
    while (true) {
        print(prompt)
        val input = readln()
        val number = input.toDoubleOrNull()
        if (number != null && number >= 0) {
            return number
        }
        println("Error: '$input' is not a valid non-negative number")
    }
}

fun main() {
    val radius = readDouble("Enter the radius of the circle: ")
    val area = circleArea(radius)
    val circumference = circleCircumference(radius)
    println("Area: %.4f".format(area))
    println("Circumference: %.4f".format(circumference))
}