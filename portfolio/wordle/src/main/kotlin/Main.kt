const val ATTEMPT_LIMIT = 6

fun main() {
    val words = readWordList("./data/words.txt")
    var play: Boolean = true
    
    val targetEval = List<Int>(5) { 2 }
    while (play) {
        var charactersLeft = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toList()
        val target = pickRandomWord(words)
        for (i in 1..ATTEMPT_LIMIT) {
            val guess = obtainGuess(i)
            val eval = evaluateGuess(guess, target)
                       
            if (eval == targetEval) {
                println("""
                |Congratulations!!
                |The word was ${"\u001b[32m" + target + "\u001b[0m"}
                |You got the correct answer in ${i} attempts.
                """.trimMargin())
                break
            }

            displayGuess(guess, eval)
            charactersLeft = remainingChars(guess, eval, charactersLeft)
            displayChars(charactersLeft, target, eval)

            if (i == ATTEMPT_LIMIT) {
                println("""
                |You haven't correctly guessed the word.
                |It was ${target}.
                """.trimMargin())
            }
        }
        print("Play again (y/n)? ")
        val new = readln()
        if (new == "n") play = false
    }
}
