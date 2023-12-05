import java.time.LocalDateTime

fun main() {
    val time = LocalDateTime.now()

    /*    if (time.hour >= 12 && time.hour < 18) { // ==, >, < , >=, <= , != , &&, ||, !
            println("Goeie middag")
        } else if (time.hour >= 18) {
            println("Goeie avond")
        } else {
            println("Goeie morgen")
        }*/

    val textToPrint = if (time.hour >= 12 && time.hour < 18) { // ==, >, < , >=, <= , != , &&, ||, !
        "Goeie middag"
    } else if (time.hour >= 18) {
        "Goeie avond"
    } else {
        "Goeie morgen"
    }

    println(textToPrint)
}