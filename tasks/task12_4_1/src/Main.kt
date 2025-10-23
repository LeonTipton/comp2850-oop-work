// Task 12.4.1: main program

fun main() {
    val centreX = readln().toDouble()
    val centreY = readln().toDouble()
    val radius = readln().toDouble()
    val centre = Point(centreX, centreY)
    
    val circle = Circle(radius, centre)
    val p = Point (4, 7)
    
    println(circle.area())
    println(circle.perimeter())
    println(if (circle contains p) "point in circle" else "point outside circle")

}
