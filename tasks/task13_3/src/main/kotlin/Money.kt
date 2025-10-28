// Task 13.3

data class Money(val euros: Int, val cents: Int) {
    init {
        require(euros >= 0) { "Euros cannot be less than zero" }
        require(cents in 0..99) { "Cents must be between 0 and 99" }
    }

    operator fun plus(other: Money) = if (cents + other.cents < 100) 
        Money(euros + other.euros, cents + other.cents) 
    else 
        Money(euros + other.euros + 1, cents + other.cents - 100)
}
