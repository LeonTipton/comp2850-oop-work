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

fun remainingChars(guess: String, eval: IntArray, alphabet: List<Char>): List<Char> {
    val wrongChars = guess.toMutableList()

    for (i in 0..4) {
        if (eval[i] != 0) {
            wrongChars.remove(guess[i])
        }
    }
    return alphabet.filterNot {chr -> chr in wrongChars}
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

fun evaluateGuess(guess: String, target: String): IntArray {
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
    return ret.toIntArray()
}

fun displayGuess(guess: String, matches: IntArray) {
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

fun displayChars(
    remainingChars: List<Char>, guess: String, matches: IntArray, previous: Pair<String,Int>
    ): Pair<String,Int> {
    var outp = mutableListOf<String>()
    val charsLeft = remainingChars.toMutableList()

    var (pChar,pEval) = previous
    if (pChar != "") {
        var tempC = guess
        var tempE = matches.joinToString(separator="")
        for ((i, c) in pChar.withIndex()) {
            if(c !in tempC) {
                tempC += c
                tempE += pEval.toString()[i]
            }
        }
        pChar = tempC
        pEval = tempE.toInt()
    } else {
        pChar = guess
        pEval = matches.joinToString(separator="").toInt()
    }

    val guessChars = pChar
    val matchers = if (pEval.toString().length >= 5) 
    pEval.toString().split("").filterNot {it.isBlank()}.map {it.toInt()}
    else 
    pEval.toString().padStart(guessChars.length,'0').split("").filterNot {it.isBlank()}.map {it.toInt()}

    val reset = "\u001b[0m"
    val green = "\u001b[32m"
    val yellow = "\u001b[33m"
    var retC = mutableListOf<Char>()
    var retM = mutableListOf<Int>()
    
    for ((i, e) in matchers.withIndex()) {
        if (e == 2) {
            outp.add(green + guessChars[i])
            charsLeft.remove(guessChars[i])
            retC.add(guessChars[i])
            retM.add(e)
        } else if (e == 1) {
            outp.add(yellow + guessChars[i])
            charsLeft.remove(guessChars[i])
            retC.add(guessChars[i])
            retM.add(e)
        }
    }

    for (chr in charsLeft) {
        outp.add(reset + chr)
    }

    println("Remaining characters: ${outp.joinToString(separator=" ")}")
    if (retM.size == 0) {
        return Pair("", 0)
    } else {
        return Pair(retC.joinToString(separator=""), retM.joinToString(separator="").toInt())
    }
}
