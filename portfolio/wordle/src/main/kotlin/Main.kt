fun main() {
    val words = readWordList("./data/words.txt")
    var play: Boolean = true
    val targetEval = List<Int> (5) { 1 }
    while (play) {
        val target = pickRandomWord(words)
        println(target)
        for (i in 1..10) {
            val guess = obtainGuess(i)
            val eval = if (isValid(guess)) evaluateGuess(guess, target) else listOf<Int>()
            if (eval == listOf<Int>()) {
                println("Invalid guess")
                if (i == 10) {
                    println("""
                    |You haven't correctly guessed the word.
                    |It was ${target}.
                    """.trimMargin())
                }
                continue
            }
            
            if (eval == targetEval) {
                println("""
                |Congratulations!!
                |You got the correct answer in ${i} attempts.
                """.trimMargin())
                break
            }
            displayGuess(guess, eval)
            if (i == 10) {
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
