const val attemptLimit = 6

fun main() {
    val words = readWordList("./data/words.txt")
    var play: Boolean = true
    
    val targetEval = List<Int> (5) { 2 }
    while (play) {
        val target = pickRandomWord(words)
        for (i in 1..attemptLimit) {
            val guess = obtainGuess(i)
            val eval = evaluateGuess(guess, target)
                       
            if (eval == targetEval) {
                println("""
                |Congratulations!!
                |You got the correct answer in ${i} attempts.
                """.trimMargin())
                break
            }
            displayGuess(guess, eval)
            if (i == attemptLimit) {
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
