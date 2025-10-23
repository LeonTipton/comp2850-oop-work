// Implement the six required functions here
import java.io.File
import kotlin.random.Random

// provides validation to the inputted word
fun isValid(word: String): Boolean {
    val regex = """\d+""".toRegex() // defines a regular expression to be any digit character (\d is defined as [0-9])
    // ensures the user input has correct length and no numbers
    if (regex.containsMatchIn(word) || word.length != WORD_LEN) {
        // if this is the case inform user and return false due to invalidity
        println("Invalid guess, please try again")
        return false
    } else {
        return true
    }
}

// reads the input file line by line and then converts that to a mutable list using lambda
fun readWordList(filename: String): MutableList<String> = File(filename).useLines { it.toMutableList<String>() }

// selects a random word from the list of available words
fun pickRandomWord(words: MutableList<String>): String {
    val index = Random.nextInt(0, words.size) // chooses an index
    val word = words[index] // picks a word at that index
    words.removeAt(index) // removes the word from the list
    return word
}

// returns characters that are either unused or (partially) correct
fun remainingChars(guess: String, eval: IntArray, alphabet: List<Char>): List<Char> {
    val wrongChars = guess.toMutableList()

    // enumerates eval into index, value pairs on each iteration
    for ((i, e) in eval.withIndex()) {
        if (e != 0) {
            // removes the guess from the incorrect characters if the guessed character is (partially) correct
            wrongChars.remove(guess[i])
        }
    }
    // returns a filter of the inputted alphabet of characters given that the character is not correct
    return alphabet.filterNot {chr -> chr in wrongChars}
}

// parses the user input
// applies the above validation
fun obtainGuess(attempt: Int): String {
    var valid = false // assume that the input is invalid
    var userInput: String // define the user input as a string
    println("Attempt $attempt")
    do {
        print("Enter your guess: ")
        // uses a safe operator to read the userinput, in the event of a nulll input, it is just set to an empty string 
        // allows the input to be usedin subsequent functions regardless of input
        userInput = readlnOrNull()?.let { it.uppercase() } ?: "" 
        valid = isValid(userInput) // updates validity of the input depending on the isValid() function
    } while (!valid)
    return userInput
}

// evaluates the input against the target
fun evaluateGuess(guess: String, target: String): IntArray {
    val ret = mutableListOf<Int>()
    
    // iterates through the characters in guess with the appropriate index
    for ((i, c) in guess.withIndex()) {
        if (c == target[i]) { // fully correct
            ret.add(2)
        } else if (c in target) { // partially correct
            ret.add(1)
        } else { // incorrect
            ret.add(0)
        }
    }
    return ret.toIntArray()
}

fun displayGuess(guess: String, matches: IntArray) {
    var outp: String = ""
    // defines output colours and reset using ANSI escape codes
    val reset = "\u001b[0m"
    val green = "\u001b[32m"
    val yellow = "\u001b[33m"
    val red = "\u001b[31m"
    
    // iterate through matches
    for ((i, m) in matches.withIndex()) {
       if (m == 2) { // correct letter
            outp += green + guess[i]
        } else if (m == 1) { // partially correct letter
            outp += yellow + guess[i]
        } else { // incorrect letter
            outp += red + guess[i]
        }
    }
    outp += reset // adds a reset to the end so following lines are not coloured
    println(outp)
}

// display the remaining characters and correctness
fun displayChars(
    remainingChars: List<Char>, guess: String, matches: IntArray, previous: Pair<String,Int>
    ): Pair<String,Int> {
    var outp = mutableListOf<String>()
    val charsLeft = remainingChars.toMutableList()

    var (pChar,pEval) = previous // splits the previous characters input
    if (pChar != "") { // if previous guess is not the first/completely incorrect
        var tempC = guess
        // converts the matches into a string
        var tempE = matches.joinToString(separator="")
        // iterate through previous characters
        for ((i, c) in pChar.withIndex()) {
            if(c !in tempC) { // if the character is not already present
                tempC += c
                tempE += pEval.toString()[i]
            }
        }
        // update previous character variables
        pChar = tempC
        pEval = tempE.toInt()
    } else { // if there are previous correct guesses
        // set previous characters and eval to the current ones
        pChar = guess
        pEval = matches.joinToString(separator="").toInt()
    }

    // declare the total characters to be guessed with their respective evaluation
    val guessChars = pChar
    // due to ints not keeping leading 0s, if the eval is [0,0,1,2,2] which becomes 122,
    // the leading 0s need padding in front before making the list of integer
    val matchers = if (pEval.toString().length >= WORD_LEN) 
    pEval.toString().split("").filterNot {it.isBlank()}.map {it.toInt()}
    else 
    pEval.toString().padStart(guessChars.length,'0').split("").filterNot {it.isBlank()}.map {it.toInt()}

    // declare colours and reset
    val reset = "\u001b[0m"
    val green = "\u001b[32m"
    val yellow = "\u001b[33m"

    // define return variables
    var retC = mutableListOf<Char>()
    var retM = mutableListOf<Int>()
    
    // iterates through the list of evaluations (size >= 5)
    for ((i, e) in matchers.withIndex()) {
        if (e == 2) { // fully correct
            outp.add(green + guessChars[i]) // add green character to output
            charsLeft.remove(guessChars[i]) // remove from remaining characters
            retC.add(guessChars[i]) // add to return characters
            retM.add(e) // add eval to return eval
        } else if (e == 1) { // partially correct
            outp.add(yellow + guessChars[i]) //add yellow character to output
            charsLeft.remove(guessChars[i])
            retC.add(guessChars[i])
            retM.add(e)
        }
    }

    for (chr in charsLeft) {
        outp.add(reset + chr) // add remaining characters to output
    }

    // output all characters with a space between them
    println("Remaining characters: ${outp.joinToString(separator=" ")}")
    
    if (retM.size == 0) { // if guess is fully incorrect
        return Pair("", 0)
    } else {
        // turns the return lists into a string and int respectively
        // zips them into a Pair
        return Pair(retC.joinToString(separator=""), retM.joinToString(separator="").toInt())
    }
}
