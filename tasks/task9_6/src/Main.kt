// Task 9.6: application to compute dataset variance

import kotlin.system.exitProcess
import java.io.FileNotFoundException

fun main(args: Array<String>) {
    // Implement main program here
    if (args.size != 1) {
        println("File not supplied")
        exitProcess(1)
    }
    
    var dataset = listOf<Double>()

    try {
        dataset = readData(args[0])
    } catch (error: FileNotFoundException) {
        println("Error: file not found")
        exitProcess(1)
    } catch (error: Exception) {
        println("Error: file parse failed")
        exitProcess(1)
    }

    val variance = variance(dataset)

    println("The variance of ${dataset} is ${variance}")

    exitProcess(0)
}
