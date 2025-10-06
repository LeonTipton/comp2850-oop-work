// Implement the six required functions here
import java.io.File
import kotlin.random.Random

fun isValid(word: String): Boolean = word.length == 5

fun readWordList(filename: String): MutableList<String> = File("words.txt").useLines { it.toMutableList<String>() }

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

fun evaluateGuess(guess: String, target: String): list<Int> {
    val ret = intListOf (5)
    for (i in 0..4) {
        ret[i] = 1 if guess[i] == target[i] else 0
    }
    return ret
}

fun displayGuess(guess: String, matches: List<Int>) {
    var out: String
    for (i in 0..4) {
        out.append(guess[i]) if matches[i] == 1 else "?"
    }
}
