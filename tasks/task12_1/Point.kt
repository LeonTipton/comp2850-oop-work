import kotlin.math.hypot

class Point(var x: Double, var y: Double) {
    fun distance() = hypot(x, y)
    fun distanceTo(point: Point) = hypot(x - point.x, y - point.y)
}

fun main() {
    val p = Point(4.5, 7.0)

    print("Enter x-coordinate: ")
    val x = readln().toDouble()

    print("Enter y-coordinate: ")
    val y = readln().toDouble()

    val uPoint = Point(x, y)

    println("Distance from origin ${uPoint.distance()}")
    println("Distance from (4.5, 7.0) ${"%.3f".format(uPoint.distanceTo(p))}")
}
