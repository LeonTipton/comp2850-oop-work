// Task 12.8.1: example of an enum class
enum class Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY,
}

fun main() {
    print("Enter a day of the week: ")
    val day = readln().uppercase()
    println(Day.valueOf(day))
}
