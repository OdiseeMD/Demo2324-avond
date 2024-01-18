fun main() {
    val scrableScore = mapOf(
        "a" to 1,
        "b" to 2,
        "c" to 4,
        "d" to 2,
        "e" to 1
    )

    val voorbeeld = mutableMapOf<String, Int>()

    println(scrableScore["a"])

    for ((key, value) in scrableScore) {
        println(key)
        println(value)
    }
}