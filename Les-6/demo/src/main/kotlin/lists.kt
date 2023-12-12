fun main() {

    twoDimensionList()
    val items1 = listOf(1, 2, 3, 4, 5)
    val items2 = mutableListOf<Int>()

    println(items1[0])


    for (item in items1) {
        println(item)
    }
}

fun twoDimensionList() {
    val example = mutableListOf(
        listOf(1, 2, 3, 4, 5, 6, 7, 8),
        listOf(1, 2, 3, 4, 5, 6, 7, 8),
        listOf(1, 2, 3, 4, 5, 6, 7, 8),
        listOf(1, 2, 3, 4, 5, 6, 7, 8),
        listOf(1, 2, 3, 4, 5, 6, 7, 8),
        listOf(1, 2, 3, 4, 5, 6, 7, 8),
        listOf(1, 2, 3, 4, 5, 6, 7, 8),
    )



    println(example)
}