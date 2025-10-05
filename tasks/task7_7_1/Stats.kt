// Task 7.7.1: stats for a numeric dataset
fun readData() = buildList {
    print("Enter numbers: ")
    while (true) {
        val line = readln()
        if (line.isEmpty()) break
        val number = line.toIntOrNull()
        if (number != null) add(number)
    }
}

fun median(numbers: List<Float>): Float {
    if (numbers.isEmpty()) return 0f
    val sorted = numbers.sorted()
    val size = sorted.size
    return if (size % 2 == 1) {
        sorted[size / 2]
    } else {
        (sorted[size / 2 - 1] + sorted[size / 2]) / 2
    }
}

fun displayStats(numbers: List<Float>) {
    if (numbers.isEmpty()) {
        println("No data to display.")
        return
    }

    val min = numbers.minOrNull() ?: 0f
    val max = numbers.maxOrNull() ?: 0f
    val avg = numbers.average().toFloat()
    val med = median(numbers)

    println("Min: $min")
    println("Max: $max")
    println("Average: $avg")
    println("Median: $med")
}

fun main() {
    val data = readData().map { it.toFloat() }
    displayStats(data)
}