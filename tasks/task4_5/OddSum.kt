// Task 4.5: summing odd integers with a for loop

fun main() {
    print("Enter a positive integer limit: ")
    val limit :ULong = readln().toULong()
    
    // this is using the formula for the sum of the first n odd numbers
    // which is S_n = n^2 where n is the count of odd numbers to sum
    // it has time complexity O(1) and space complexity O(1)
    var formula = (limit + 1UL) / 2UL
    formula *= formula
    println("The sum of odd integers from 1 to $limit as $formula")

    // this is using a for loop to sum the odd numbers
    // it has time complexity O(n) and space complexity O(1)
    var sum :ULong = 0UL
    for (i :ULong in 1UL..limit step 2) {
        sum += i
    }
    println("The sum of odd integers from 1 to $limit is $sum")
}