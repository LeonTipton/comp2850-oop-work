import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.assertions.throwables.shouldThrow
import java.io.FileNotFoundException
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.collections.shouldBeSmallerThan
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.collections.shouldContainExactly

@Suppress("unused")
class WordleTest : StringSpec({
    // isValid tests
    
    "Valid input word of length 5 (ABORT)" {
        isValid("ABORT") shouldBe true
    }
    "Valid input word of length 4 (ABAC)" {
        isValid("ABAC") shouldBe false
    }
    "Valid input word of length 6 (ABORTS)" {
        isValid("ABORTS") shouldBe false
    }
    "Valid input word of length 0 ()" {
        isValid("") shouldBe false
    }
    "Valid input word of length 10 (ABANDONERS)" {
        isValid("ABANDONERS") shouldBe false
    }

    // readWordList tests
    
    "Test file is read to mutable list of size 21" {
        val testfile = readWordList("./data/test.txt")
        testfile shouldHaveSize 21
    }
    "Test file contains specific names formatted alphabetically" {
        val testfile = readWordList("./data/test.txt")
        val complist = mutableListOf("ABACK", "ABASE", "ABATE", "ABBEY", "ABBOT", "ABHOR", "ABIDE", "ABLED", "ABODE", "ABORT", "ABOUT", "ABOVE", "ABUSE", "ABYSS", "ACORN", "ACRID", "ACTOR", "ACUTE", "ADAGE", "ADAPT", "ADEPT")
        testfile shouldBe complist
    }
    "Throws FileNotFoundException for missing file" {
        shouldThrow<FileNotFoundException> { readWordList("") }
    }
    "Throws FileNotFoundException for incorreect file" {
        shouldThrow<FileNotFoundException> { readWordList("./data/tes.txt") }
    }
    "Throws FileNotFoundException for incorrect file" {
        shouldThrow<FileNotFoundException> { readWordList("./data/test.tx") }
    }
    "Throws FileNotFoundException for incorrect directory" {
        shouldThrow<FileNotFoundException> { readWordList("./wrongdir/test.txt") }
    }

    // pickRandomWord tests
    
    "Picks a random word from the list of characters used in previous test set" {
        val randlist = mutableListOf("ABACK", "ABASE", "ABATE", "ABBEY", "ABBOT", "ABHOR", "ABIDE", "ABLED", "ABODE", "ABORT", "ABOUT", "ABOVE", "ABUSE", "ABYSS", "ACORN", "ACRID", "ACTOR", "ACUTE", "ADAGE", "ADAPT", "ADEPT")
        val complist = mutableListOf("ABACK", "ABASE", "ABATE", "ABBEY", "ABBOT", "ABHOR", "ABIDE", "ABLED", "ABODE", "ABORT", "ABOUT", "ABOVE", "ABUSE", "ABYSS", "ACORN", "ACRID", "ACTOR", "ACUTE", "ADAGE", "ADAPT", "ADEPT")
        val word = pickRandomWord(randlist)
        word shouldBeIn complist 
    }
    "The list of possible words decreases in size" {
        val randlist = mutableListOf("ABACK", "ABASE", "ABATE", "ABBEY", "ABBOT", "ABHOR", "ABIDE", "ABLED", "ABODE", "ABORT", "ABOUT", "ABOVE", "ABUSE", "ABYSS", "ACORN", "ACRID", "ACTOR", "ACUTE", "ADAGE", "ADAPT", "ADEPT")
        val complist = mutableListOf("ABACK", "ABASE", "ABATE", "ABBEY", "ABBOT", "ABHOR", "ABIDE", "ABLED", "ABODE", "ABORT", "ABOUT", "ABOVE", "ABUSE", "ABYSS", "ACORN", "ACRID", "ACTOR", "ACUTE", "ADAGE", "ADAPT", "ADEPT")
        val word = pickRandomWord(randlist)
        randlist shouldBeSmallerThan complist
    }
    "The chosen word is no longer be in the list of words" {
        val complist = mutableListOf("ABACK", "ABASE", "ABATE", "ABBEY", "ABBOT", "ABHOR", "ABIDE", "ABLED", "ABODE", "ABORT", "ABOUT", "ABOVE", "ABUSE", "ABYSS", "ACORN", "ACRID", "ACTOR", "ACUTE", "ADAGE", "ADAPT", "ADEPT")
        val word = pickRandomWord(complist)
        complist.shouldNotContain(word)
    }
    "IllegalArgumentException thrown if the input list is empty" {
        val complist = mutableListOf<String> ()
        shouldThrow<IllegalArgumentException> { pickRandomWord(complist) }
    }

    //evaluateGuess tests

    "Guess: 'ABACK' with Target: 'ABACK' returns [2,2,2,2,2]" {
        val guess = "ABACK"
        val target = "ABACK"
        val complist = listOf(2,2,2,2,2)
        
        evaluateGuess(guess, target) shouldContainExactly complist
    }
    "Guess: 'ABACK' with Target: 'WORLD' returns [0,0,0,0,0]" {
        val guess = "ABACK"
        val target = "WORLD"
        val complist = listOf(0,0,0,0,0)
        
        evaluateGuess(guess, target) shouldContainExactly complist
    }
    "Guess: 'ABACK' with Target: 'ABASE' returns [2,2,2,0,0]" {
        val guess = "ABACK"
        val target = "ABASE"
        val complist = listOf(2,2,2,0,0)
        
        evaluateGuess(guess, target) shouldContainExactly complist
    }
    "Guess: 'WHALE' with Target: 'BASTE' returns [0,0,1,0,2]" {
        val guess = "WHALE"
        val target = "BASTE"
        val complist = listOf(0,0,1,0,2)
        
        evaluateGuess(guess, target) shouldContainExactly complist
    }
    "Guess: 'ABASE' with Target: 'LIMBO' returns [0,1,0,0,0]" {
        val guess = "ABASE"
        val target = "LIMBO"
        val complist = listOf(0,1,0,0,0)
        
        evaluateGuess(guess, target) shouldContainExactly complist
    }
    "Guess: 'BELTS' with Target: 'LIMBO' returns [1,0,1,0,0]" {
        val guess = "BELTS"
        val target = "LIMBO"
        val complist = listOf(1,0,1,0,0)
        
        evaluateGuess(guess, target) shouldContainExactly complist
    }
    "Guess: 'LOAMY' with Target: 'LIMBO' returns [2,1,0,1,0]" {
        val guess = "LOAMY"
        val target = "LIMBO"
        val complist = listOf(2,1,0,1,0)
        
        evaluateGuess(guess, target) shouldContainExactly complist
    }
})
