fun main() {
    //voorbeeldVerkeerslicht()
    //voorbeeldWeekend()
    voorbeeldWeer()
}

private fun voorbeeldWeer() {
    val isRaining = true
    val isFreezing = false

    val result = when {
        isRaining && isFreezing -> {
            println("iets anders")
            "Let op voor ijzel"
        }

        isRaining && !isFreezing -> "Vergeet je paraplu niet"
        isFreezing -> "Doe een dikke jas aan"
        else -> "Het is zomer"
    }

    println(result)
}

private fun voorbeeldWeekend() {
    val dayNumber = 1

    when (dayNumber) {
        in 1..5 -> println("weekdag")
        6, 7 -> println("weekend")
        else -> println("ongeldig dag nummer")
    }
}

private fun voorbeeldVerkeerslicht() {
    val trafficColor = "Groen"

    when (trafficColor) {
        "Rood" -> {
            println("Stop")
            println("Stop")
        }

        "Oranje" -> println("Vertragen")
        "Groen" -> println("Rij door")
        "Groen" -> println("tweede groen")
    }
}