fun main() {
    println("Welcome to the Pizza Ordering System!")
    println("Please choose a pizza:")
    println("a) Margherita")
    println("b) Pepperoni")
    println("c) Hawaiian")
    println("d) Veggie")

    var input: String
    do {

        print("Enter your choice (a, b, c, or d): ")
        input = readln().lowercase()

        val isValid = if (input.length == 1 && input[0] in 'a'..'d') true else false

        if (isValid) {
            println("Order accepted")
        } else {
            println("Invalid choice!")
        }
    } while (!isValid)
}