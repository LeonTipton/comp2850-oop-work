// Task 6.4.1

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class GradeTest : StringSpec({
    "Grade of Distinction for mark 100" {
        grade(100) shouldBe "Distinction"
    }
    "Grade of Distinction for mark 85" {
        grade(85) shouldBe "Distinction"
    }
    "Grade of Distinction for mark 70" {
        grade(70) shouldBe "Distinction"
    }

    "Grade of Pass for mark 69" {
        grade(69) shouldBe "Pass"
    }
    "Grade of Pass for mark 55" {
        grade(55) shouldBe "Pass"
    }
    "Grade of Pass for mark 40" {
        grade(40) shouldBe "Pass"
    }

    "Grade of Fail for mark 39" {
        grade(39) shouldBe "Fail"
    }
    "Grade of Fail for mark 20" {
        grade(20) shouldBe "Fail"
    }
    "Grade of Fail for mark 0" {
        grade(0) shouldBe "Fail"
    }

    "Grade of ? for mark  -1" {
        grade(-1) shouldBe "?"
    }
    "Grade of ? for mark -20" {
        grade(-20) shouldBe "?"
    }
    "Grade of ? for mark 101" {
        grade(101) shouldBe "?"
    }
    "Grade of ? for mark 120" {
        grade(120) shouldBe "?"
    }
    
})
