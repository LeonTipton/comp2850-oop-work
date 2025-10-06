// Task 8.3: functions for temperature analysis

typealias Record = Pair<String,Double>

fun fetchData(): List<Record> {
  val data = mutableListOf<Record>()
  while (true) {
    print("Enter station name: ")
    val name = readln()
    if (name.isEmpty()) break

    print("Enter temperature recorded: ")
    val tempInput = readln()
    val temp = tempInput.toDoubleOrNull()
    if (temp == null) {
      println("Invalid temperature. Please enter a valid number.")
      continue
    }

    data.add(name to temp)
  }
  return data
}

// Challenge: compute average temperature with one line of code
// in main(), instead of using the function below!

fun averageTemp(data: List<Record>): Double {
    var sum = 0.0
    for (record in data) {
        sum += record.second
    }
    return sum / data.size
}
