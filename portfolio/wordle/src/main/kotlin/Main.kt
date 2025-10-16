fun main() {
    val words = readWordList("./data/words.txt")
    var play: Boolean = true
    val targetEval = List<Int> (5) { 1 }
    while (play) {
        val target = pickRandomWord(words)
        for (i in 1..10) {
            val guess = obtainGuess(i)
            val eval = if (isValid(guess)) evaluateGuess(guess, target) else listOf<Int>()
            if (eval == listOf<Int>()) {
                println("Invalid guess")
            }
            displayGuess(guess, eval)
            if (eval == targetEval) {
                println("""
                |Congratulations!!
                |You got the correc answer in ${i} attempts.
                """.trimMargin())
                break
            }
        }
        print("Play again? ")
        val new = readln()
        if (new == "no") play = false
    }
}
