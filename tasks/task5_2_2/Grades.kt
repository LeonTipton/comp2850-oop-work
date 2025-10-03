// Task 5.2.2: conversion of marks into grades, using a function
import kotlin.system.exitProcess

fun grade(mark: Int) = when (mark) {
    in 0..39 -> "Fail"
    in 40..69 -> "Pass"
    in 70..100 -> "Distinction"
    else -> "?"
}

fun main(args: Array<String>) {
    if (args.size < 1) {
        println("Invalid number of arguments")
        exitProcess(1)
    }

    for (arg in args) {
        val mark = arg.toIntOrNull()
        if (mark == null) {
            println("Invalid mark: $arg")
            continue
        }
        val result = grade(mark)
        if (result == "?") {
            println("Invalid mark: $mark")
        } else {
            println("$mark is a $result")
        }
    }
}