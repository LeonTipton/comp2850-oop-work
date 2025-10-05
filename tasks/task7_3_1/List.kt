// Task 7.3.1: list element access
fun main() {
    val numbers = listOf(9, 6, 3, 2, 8, 5)
    println(numbers)
    // numbers.add(1)
    // println(numbers)
    println(numbers[0])
    println(numbers.get(0))
    // println(numbers[10])
    println((numbers.slice(2..4)))
    println(numbers.first())
    println(numbers.last())
    
}