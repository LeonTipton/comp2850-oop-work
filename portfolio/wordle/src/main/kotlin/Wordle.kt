// Implement the six required functions here
import java.io.File
import kotlin.random.Random

fun isValid(word: String): Boolean = word.length == 5

fun readWordList(filename: String): MutableList<String> = File(filename).useLines { it.toMutableList<String>() }

fun pickRandomWord(words: MutableList<String>): String {
    val index = Random.nextInt(0, words.size)
    val word = words[index]
    words.removeAt(index)
    return word
}

fun obtainGuess(attempt: Int): String {
    println("Attempt $attempt")
    print("Enter your guess: ")
    return readln()
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val ret = mutableListOf<Int>()
    for (i in 0..4) {
        if (guess[i] == target[i]) {
            ret.add(1)
        } else {
            ret.add(0)
        }
        ret[i] = if (guess[i] == target[i]) 1 else 0
    }
    return ret.toList()
}

fun displayGuess(guess: String, matches: List<Int>) {
    var out = CharArray(5) { '?' }
    for (i in 0..4) {
       if (matches[i] == 1) {
            out[i] = guess[i]
        }
    }
    println("${out.toString()}")
}
