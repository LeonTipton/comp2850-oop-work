import kotlin.math.roundToInt
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Please provide exactly 3 command line arguments.")
        exitProcess(1)
    }
    
    val avg = ((args[0].toDouble() + args[1].toDouble() + args[2].toDouble()) / 3).roundToInt()
    val grade = when (avg) {
        in 0..39   -> "Fail"
        in 40..69  -> "Pass"
        in 70..100 -> "Distinction"
        else       -> {
            println("Average out of range")
            exitProcess(1)
        }
    }
    println("Average: $avg")
    println("Grade: $grade")
}