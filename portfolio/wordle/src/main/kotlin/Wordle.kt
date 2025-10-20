// Implement the six required functions here
import java.io.File
import kotlin.random.Random

fun isValid(word: String): Boolean {
    val regex = "[0-9]+".toRegex()
    if (regex.containsMatchIn(word) || word.length != 5) {
        println("Invalid guess, please try again")
        return false
    } else {
        return true
    }
}

fun readWordList(filename: String): MutableList<String> = File(filename).useLines { it.toMutableList<String>() }

fun pickRandomWord(words: MutableList<String>): String {
    val index = Random.nextInt(0, words.size)
    val word = words[index]
    words.removeAt(index)
    return word
}

fun obtainGuess(attempt: Int): String {
    var valid = false
    var userInput: String
    println("Attempt $attempt")
    do {
        print("Enter your guess: ")
        userInput = readlnOrNull()?.let { it.uppercase() } ?: ""
        valid = isValid(userInput)
    } while (!valid)
    return userInput
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val ret = mutableListOf<Int>()
    
    for (i in 0..4) {
        if (guess[i] == target[i]) {
            ret.add(2)
        } else if (guess[i] in target) {
            ret.add(1)
        } else {
            ret.add(0)
        }
    }
    return ret.toList()
}

fun displayGuess(guess: String, matches: List<Int>) {
    var outp: String = ""
    val reset = "\u001b[0m"
    val green = "\u001b[32m"
    val yellow = "\u001b[33m"
    val red = "\u001b[31m"
    
    for (i in 0..4) {
       if (matches[i] == 2) {       
            outp += green + guess[i]
        } else if (matches[i] == 1) {
            outp += yellow + guess[i]
        } else {
            outp += red + guess[i]
        }
    }
    outp += reset
    println(outp)
}
