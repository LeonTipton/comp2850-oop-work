// Task 12.3.1: secondary constructors

class Point(var x: Double, var y: Double) {
    constructor(): this(0.0, 0.0)
    constructor(x: Int, y: Int): this(x.toDouble(), y.toDouble())
}

fun main() {
    val p = Point(4, 7)
    println("(${p.x}, ${p.y})")
}
