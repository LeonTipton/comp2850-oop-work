// Task 8.3: weather station temperature analysis program

fun main() {
    // Add code here to:
    //   - Fetch data
    //   - Find records with lowest and and highest temperatures
    //   - Compute average temperature
    //   - Display all of these statistics
    val dataset = fetchData()
    println("The minimum temperature is ${dataset.minBy { it.second }}")
    println("The maximum temperature is ${dataset.maxBy { it.second }}")
    println("The average temperature is ${ dataset.sumOf {it.second} / dataset.size }")

}
