// Task 13.3

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class MoneyTest : StringSpec({
    "Can create a Money object" {
        val m = Money(1, 50)
        withClue("euros") { m.euros shouldBe 1 }
        withClue("cents") { m.cents shouldBe 50 }
    }

    "Can create a Money object with different parameters" {
        val m = Money(2, 99)
        withClue("euros") { m.euros shouldBe 2 }
        withClue("cents") { m.cents shouldBe 99 }
    }
    "Cannot create a money object with an invalid number of euros" {
        shouldThrow<IllegalArgumentException> { Money(-1, 50) }
    }
    "Cannot create a money object with an invalid number of cents" {
        shouldThrow<IllegalArgumentException> { Money(1, -50) }
    }
    "Cannot create a money object with an invalid number of euros & cents" {
        shouldThrow<IllegalArgumentException> { Money(-1, -50) }
    }
    "Cannot create a money object with cents > 99" {
        shouldThrow<IllegalArgumentException> { Money(-2, 120) }
    }
    "€1.50 + €1.00 is €2.50" {
        Money(1, 50) + Money(1, 0) shouldBe Money(2, 50) 
    }
    "€1.50 + €2.00 is €3.50" {
        Money(1, 50) + Money(2, 0) shouldBe Money(3, 50)
    }
    "€1.50 + €0.01 is €1.51" {
        Money(1, 50) + Money(0, 1) shouldBe Money(1, 51)
    }
    "€2.99 + €0.01 is €3.00" {
        Money(2, 99) + Money(0, 1) shouldBe Money(3, 0)
    }

})
