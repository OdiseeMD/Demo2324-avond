const val CURRENT_YEAR = 2023

fun main() {

    val name = "matthias"
    var age: Int = 12

    age = 21

    println("Hallo $name, je geboortedatum is ${CURRENT_YEAR - age}!")
    printInfo(name, age)
    println(getInfoString(age = age, name = name))
    println(getInfoString(age = age))
}

fun printInfo(name: String, age: Int) {
    println("Hallo $name, je geboortedatum is ${CURRENT_YEAR - age}!")
}

fun getInfoString(name: String = "world", age: Int): String {
    return "Hallo $name, je geboortedatum is ${CURRENT_YEAR - age}!"
}