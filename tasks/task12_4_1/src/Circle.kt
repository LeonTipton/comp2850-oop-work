// Task 12.4.1: Circle class
import kotlin.math.PI
import kotlin.math.pow

class Circle(val r: Double, val centre: Point) {
    constructor(r: Int, centre: Point): this(r.toDouble(), centre)

    init {
        require(r > 0) { "Error: radius must be greater than 0" }
    }

    fun area(): Double = PI * r.pow(2)
    fun perimeter(): Double = 2 * PI * r

    infix fun contains(point: Point): Boolean = point.distanceTo(centre) < r
}