// Task 3.1: command line arguments
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("No arguments provided.")
        exitProcess(1)
    }

    println("Arguments provided:")
    for ((index, arg) in args.withIndex()) {
        println("Argument $index: $arg")
    }
}