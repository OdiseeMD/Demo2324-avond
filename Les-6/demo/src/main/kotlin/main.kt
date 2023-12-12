import kotlin.math.sqrt

fun main() {
    val intPakket = Pakket<Int>(10, PakketGrootte.MEDIUM)
    val booleanPakket = Pakket<Boolean>(true, PakketGrootte.SMALL)
    val stringPakket = Pakket<String>("Hello World!")

    if (stringPakket == Pakket("Hello World!")) {
        println("zelfde")
    } else {
        println("Niet dezelfde")
    }

    println(stringPakket)
    val x = stringPakket.copy(pakketGrootte = PakketGrootte.MEDIUM)

    val postbodeJef = Postbode("Jef")
    val postbodeJan = Postbode("Jan")

    postbodeJef.leverAf(intPakket, success = true)
    postbodeJef.leverAf(booleanPakket, success = false)
    postbodeJan.leverAf(stringPakket, success = true)

    Postbode.aantalGeleverdePakketen = 100
    Postbode.aantalDagen = 50
    Postbode.printStatistieken()

    println(43.squareRoot)
    println(intPakket.pakketGrootte.prijs)

    val postbode: Postbode? = null

    val name = postbode?.also {
        println(it)
        it.name
    }
}


data class Pakket<T>(val inhoud: T, val pakketGrootte: PakketGrootte = PakketGrootte.LARGE)


enum class PakketGrootte {
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE
}

val PakketGrootte.prijs: Double
    get() {
        return when (this) {
            PakketGrootte.SMALL -> 10.0
            PakketGrootte.MEDIUM -> 12.95
            PakketGrootte.LARGE -> 15.0
            PakketGrootte.EXTRA_LARGE -> 23.99
        }
    }


class Postbode(val name: String) {

    companion object Statistieken {
        var aantalGeleverdePakketen = 0
        var aantalDagen = 0
        var aantalNietAfgeleverdePakketen = 0
    }

    fun <T> leverAf(pakket: Pakket<T>, success: Boolean) {
        if (success) {
            aantalGeleverdePakketen++
        } else {
            aantalNietAfgeleverdePakketen++
        }
    }
}

val Postbode.Statistieken.gemiddeldAantalLeveringenPerdag: Int
    get() {
        return aantalGeleverdePakketen / aantalDagen
    }

var Postbode.Statistieken.demo: Int
    get() {
        return 0
    }
    set(value) {
        aantalGeleverdePakketen = value
        aantalNietAfgeleverdePakketen = value
    }

val Int.squareRoot: Double
    get() {
        return sqrt(this.toDouble())
    }

val String.isEmail: Boolean
    get() {
        return this.contains("@")
    }

val String.isValidPassword: Boolean
    get() {
        return true
    }

fun Postbode.Statistieken.printStatistieken() {

    println("aantal afgeleverde pakketten $aantalGeleverdePakketen")
    println("aantal niet-afgeleverde pakketten $aantalNietAfgeleverdePakketen")
    println("Gemiddelde aantal pakketen ${Postbode.gemiddeldAantalLeveringenPerdag}")
}

/*
object Statistieken {
    var aantalGeleverdePakketen = 0
    var aantalDagen = 0
    var aantalNietAfgeleverdePakketen = 0
}
*/

/*
class IntPakket(val inhoud: Int)
class BooleanPakket(val inhoud: Boolean)
class StringPakket(val inhoud: String)
class DoublePakket(val inhoud: Double)
*/
