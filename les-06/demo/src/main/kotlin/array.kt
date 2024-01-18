fun main() {
    val items = arrayOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val example = Array<Int?>(8) { null }
    val example2D = Array<Array<Int?>>(8) { Array(8) { null } }
    
    println(items[1])

    items[0] = 10
    println(items[0])

    println(items.joinToString())
}

// MutableList => Geen vaste lengte en inhoud wijzigbaar
// Array => vaste lengte maar inhoud wijzigbaar
// List => inhoud niet wijzigbaar.