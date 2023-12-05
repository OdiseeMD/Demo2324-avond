fun main() {
    var name: String? = "Matthias"

    printName(null)
    printName("Matthias")

}

fun printName(name: String?) {

    val realName = name ?: "John Doe"
    val length = name?.length ?: 0

    println(realName)
    println("De lengte van je naam is $length")

}