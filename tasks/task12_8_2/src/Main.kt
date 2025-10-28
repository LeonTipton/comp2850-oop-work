// Task 12.8.2: program to manipulate playing cards
import Card.Rank
import Card.Suit

fun main() {
    val deck = mutableListOf<Card>()
    for (suit in Suit.values()) {
        for (rank in Rank.values()) {
            deck.add(Card(rank, suit))
        }
    }
    deck.shuffle()

    for (card in deck) println("${card.fullName} -> ${card}")
}
