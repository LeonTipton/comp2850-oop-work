const val ATTEMPT_LIMIT = 6

fun main() {
    val words = readWordList("./data/words.txt") // builds a list of acceptable words by parsing a \n delimited file
    var play: Boolean = true
    val targetEval = IntArray(5) { 2 } // target evaluation for a correct word
    
    do {
        var charactersLeft = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toList() // initialises the list of unused characters as all characters
        var prev = Pair("", 0) // initialises previous guesses as empty
        val target = pickRandomWord(words) // selects a pseudo-random target
        // main game loop
        for (i in 1..ATTEMPT_LIMIT) {
            val guess = obtainGuess(i) // obtains a guess (with validation)
            val eval = evaluateGuess(guess, target) // compares the guess to the correct answer - returns an intArray of size 5
            
            // checks the correctness of the answer
            // provides an appropriate answer and exits play loop if correct guess
            if (eval.contentEquals(targetEval)) {
                println("""
                |Congratulations!!
                |The word was ${"\u001b[32m" + target + "\u001b[0m"}
                |You got the correct answer in ${i} attempts.
                """.trimMargin())
                break
            }

            // if the guess is incorrect/partially correct, show a coloured output of the guess indicating correctness
            // red for incorrect character, yellow for incorrect position, green for correct position
            displayGuess(guess, eval)
            charactersLeft = remainingChars(guess, eval, charactersLeft) // removes the incorrectly guessed characters from the list of remaining characters
            prev = displayChars(charactersLeft, guess, eval, prev) // displays the remaining characters and appropriate colour (if necessay)
            
            // if not guessed in enough attempts display appropriate failure message
            if (i == ATTEMPT_LIMIT) {
                println("""
                |You haven't correctly guessed the word.
                |It was ${target}.
                """.trimMargin())
            }
        }
        // allows for multiple playthroughs with a guaranteed different word
        print("Play again (y/n)? ")
        val new = readln()
        if (new == "n") play = false
    } while (play && words != listOf<String>()) // ensures the user wants to play again and that the list of words is not empty
}
