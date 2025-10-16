// Task 9.6: functions for dataset variance calculation
import kotlin.math.pow
import java.io.File

// Add variance() function here
fun variance(dataset: List<Double>): Double {
    require(dataset.size > 1) { "not enough data" }
    
    val mean = dataset.average()
    println(mean)
    var summation: Double = 0.0

    for (dp in dataset) {
        summation += (dp - mean).pow(2)
    }

    return summation / (dataset.size - 1)
}
// Add readData() function here
fun readData(filename: String) = buildList {
    File(filename).forEachLine {
        add(it.toDouble())
    }
}