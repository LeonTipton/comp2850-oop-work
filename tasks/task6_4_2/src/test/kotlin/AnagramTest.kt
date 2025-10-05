// Task 6.4.2

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class AnagramTest: StringSpec({
    "Anagrams" {
        withClue("Listen and Silent are anagrams") {
            "Listen" anagramOf "Silent" shouldBe true
        }
        withClue("Triangle and Integral are anagrams") {
            "Triangle" anagramOf "Integral" shouldBe true
        }
        withClue("Apple and Pabble are not anagrams") {
            "Apple" anagramOf "Pabble" shouldBe false
        }
        withClue("Apple and apple are anagrams (case insensitive)") {
            "Apple" anagramOf "apple" shouldBe true
        }
        withClue("Apple and appLe are anagrams (case insensitive)") {
            "Apple" anagramOf "appLe" shouldBe true
        }
        withClue("Apple and applee are not anagrams (different lengths)") {
            "Apple" anagramOf "applee" shouldBe false
        }
    }

    "Empty strings" {
        withClue("Two empty strings are anagrams") {
            "" anagramOf "" shouldBe false
        }
        withClue("Empty string and non-empty string are not anagrams") {
            "" anagramOf "Nonempty" shouldBe false
        }
        withClue("Non-empty string and empty string are not anagrams") {
            "Nonempty" anagramOf "" shouldBe false
        }
    }

})